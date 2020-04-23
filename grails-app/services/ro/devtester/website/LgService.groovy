package ro.devtester.website

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory
import org.springframework.scheduling.annotation.Scheduled

@Transactional
class LgService {

    static lazyInit = false

    @Scheduled(fixedDelay = 21600000L, initialDelay = 1000L)
    def serviceMethod() {

        Latest.executeUpdate("delete Latest")

        def list = ['0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'R', 'S', 'T', 'U', 'V', 'Z']

        list.each {

            RestBuilder restBuilder = new RestBuilder()
            def resp = restBuilder.get("http://csmg.lgmobile.com:9002/csmg/b2c/client/web_model_list.jsp?country=" + it)

            def reader = new StringReader(resp.body.toString())
            def doc = DOMBuilder.parse(reader)
            def records = doc.documentElement

            use(DOMCategory) {
                def total_count = records.getElementsByTagName('total_count').item(0).childNodes.item(0)?.nodeValue?.toString()?.toInteger()

                (0..total_count - 1).each {
                    def model = records.getElementsByTagName('model').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                    def swversion = records.getElementsByTagName('swversion').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                    def buyer = records.getElementsByTagName('buyer').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                    def region = records.getElementsByTagName('region').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                    def country = records.getElementsByTagName('country').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                    def buyer_name = records.getElementsByTagName('buyer_name').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                    def live_date = records.getElementsByTagName('live_date').item(it as int).childNodes.item(0)?.nodeValue?.toString()

                    def firmwares = new Latest(model: model, swversion: swversion, buyer: buyer, region: region, country: country, buyer_name: buyer_name, date: new Date().parse("yyyy-MM-dd", live_date))
                    firmwares.save(flush: true)
                }
            }
        }
    }

    def storeAndGetFirmwareByImei(String esn) {

        RestBuilder restBuilder = new RestBuilder()
        def resp = restBuilder.get("http://csmg.lgmobile.com:9002/csmg/b2c/client/auth_model_check2.jsp?esn=" + esn)

        def reader = new StringReader(resp.body.toString())
        def doc = DOMBuilder.parse(reader)
        def records = doc.documentElement

        use(DOMCategory) {

            def total_count = records.getElementsByTagName('auth_model_check').getLength()

            (0..total_count - 1).each {
                def model = records.getElementsByTagName('model').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                def response_esn = records.getElementsByTagName('esn').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                def suffix = records.getElementsByTagName('suffix').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                def sw_version = records.getElementsByTagName('sw_version').item(it as int).childNodes.item(0)?.nodeValue?.toString()
                def sw_url = records.getElementsByTagName('sw_url').item(it as int).childNodes.item(0)?.nodeValue?.toString()

                def existingFirmware = Imei.findByEsnAndSw_version(esn, sw_version)
                if (existingFirmware?.sw_version != sw_version) {
                    def imei = new Imei(model: model, esn: response_esn, suffix: suffix, sw_version: sw_version, sw_url: sw_url)
                    imei.save(flush: true)
                }
            }
        }
    }
}
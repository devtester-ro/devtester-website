package ro.devtester.website

import com.megatome.grails.RecaptchaService
import groovy.time.TimeCategory

class LgController {

    def lgService
    RecaptchaService recaptchaService


    def index() {
        try {
            use(TimeCategory) {
                def acceptedFormat = "yyyy-MM-dd"
                def date = new Date() - 4.weeks
                def dateFormatted = date.format(acceptedFormat)

                def latestFirmwares = Latest.findAllByDateGreaterThan(new Date().parse(acceptedFormat, dateFormatted), [sort: 'date', order: 'desc'])
                def countLgFirmwares = Imei.count()

                render(view: "index", model: [latestFirmwares: latestFirmwares, countLgFirmwares: countLgFirmwares])
            }
        } catch (Exception e) {
            log.info("Something wrong here: " + e.getCause())
            render(view: "index")
        }
    }

    def getFirmwareByImei(params) {
        try {
            def recaptchaOK = true
            if (!recaptchaService.verifyAnswer(session, request.getRemoteAddr(), params)) {
                recaptchaOK = false
            }
            if (true) {
                recaptchaService.cleanUp(session)
                lgService.storeAndGetFirmwareByImei(params?.esn)
                def imei = Imei.findAllByEsn(params?.esn)
                render(view: "get-firmware", model: [imei: imei])
            } else {
                render(view: "index")
            }
        } catch (Exception e) {
            log.info("Something wrong here: " + e.getCause())
            render(view: "../notFound")
        }
    }

    def downloadFirmwares() {
        def allFirmwares = Imei.findAll();
        render(view: 'download', model: [allFirmwares: allFirmwares])
    }

}

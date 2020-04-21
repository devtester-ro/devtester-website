package ro.devtester.website

import groovy.time.TimeCategory

class LgController {

    def lgService

    def index() {
        try {
            use(TimeCategory) {
                def acceptedFormat = "yyyy-MM-dd"
                def date = new Date() - 10.weeks
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
            lgService.storeAndGetFirmwareByImei(params?.esn)
            def imei = Imei.findAllByEsn(params?.esn)
            render(view: "get-firmware", model: [imei: imei])
        } catch (Exception e) {
            log.info("Something wrong here: " + e.getCause())
            render(view: "../notFound")
        }
    }

    def downloadFirmwares() {
        //TODO
    }

}

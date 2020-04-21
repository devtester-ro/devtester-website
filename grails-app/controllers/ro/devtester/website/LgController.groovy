package ro.devtester.website

import groovy.time.TimeCategory

class LgController {

    def lgService

    def index() {
        use(TimeCategory) {
            def acceptedFormat = "yyyy-MM-dd"
            def date = new Date() - 10.weeks
            def dateFormatted = date.format(acceptedFormat)

            def latestFirmwares = Latest.findAllByDateGreaterThan(new Date().parse(acceptedFormat, dateFormatted), [sort: 'date', order: 'desc'])
            [latestFirmwares: latestFirmwares]

            def countLgFirmwares = Imei.count()
            [countLgFirmwares: countLgFirmwares]
        }
    }

    def getFirmwareByImei(params) {
        lgService.getFirmwareByImei(params?.esn)
        def imei = Imei.findAllByEsn(params?.esn)
        render(view: "get-firmware", model: [imei: imei])
    }

}

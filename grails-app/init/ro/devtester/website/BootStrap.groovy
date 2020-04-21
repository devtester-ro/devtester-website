package ro.devtester.website

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {
    def init = { servletContext ->
        Latest.saveAll(
                new Latest(model: "testModel", swversion: "testSw", buyer: "testBuyer", region: "testRegion", country: "RO", sw_uri: "http://mock", buyer_name: "devTester", date: new Date().parse("yyyy-MM-dd", '2014-04-01'))
        )
    }
    def destroy = {
    }
}

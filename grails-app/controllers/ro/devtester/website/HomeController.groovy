package ro.devtester.website

class HomeController {

    def ads() {
        def ads = this.class.classLoader.getResourceAsStream('analytics/ads.txt')
        render file: ads, contentType: "text/plain"
    }

    def robot() {
        def ads = this.class.classLoader.getResourceAsStream('analytics/robots.txt')
        render file: ads, contentType: "text/plain"
    }

    def sitemap() {
        def ads = this.class.classLoader.getResourceAsStream('analytics/sitemap.xml')
        render file: ads, contentType: "text/xml"
    }

    def bing() {
        def bing = this.class.classLoader.getResourceAsStream('analytics/BingSiteAuth.xml')
        render file: bing, contentType: "text/xml"
    }

    def alexa() {
        def alexa = this.class.classLoader.getResourceAsStream('analytics/UMFVD0G34vxPsMLmiZtSTYOLT1o.html')
        render file: alexa, contentType: "text/html"
    }

    def yandex() {
        def yandex = this.class.classLoader.getResourceAsStream('analytics/yandex_7f0114fed975a742.html')
        render file: yandex, contentType: "text/html"
    }

    def norton() {
        def norton = this.class.classLoader.getResourceAsStream('analytics/nortonsw_53759460-f70e-0.html')
        render file: norton, contentType: "text/html"
    }

    def googleSiteVerify() {
        def googleSiteVerify = this.class.classLoader.getResourceAsStream('analytics/google68b5fbb6a8149f4d.html')
        render file: googleSiteVerify, contentType: "text/html"
    }

}

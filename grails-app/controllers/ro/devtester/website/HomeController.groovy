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

    def about() {

    }
}

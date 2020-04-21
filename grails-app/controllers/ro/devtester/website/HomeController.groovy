package ro.devtester.website

class HomeController {

    def adstxt() {
        def absolutePath = this.class.getClassLoader().getResource("analytics/ads.txt").file
        render file: new File(absolutePath), contentType: "text/plain"
    }

    def about() {

    }
}

package ro.devtester.website

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: '/index')
        "/about"(view: '/home/about')
        "/projects/lg-firmwares"(view: '/lg/index')
        "/projects/lg-firmwares/install"(view: '/lg/install')
        "/projects/lg-firmwares/drivers"(view: '/lg/drivers')
        "/projects/lg-firmwares/fast-dormancy"(view: '/lg/fast-dormancy')
        "/projects/lg-firmwares/mlt"(view: '/lg/mlt')
        "/projects/nintendo-switch"(view: '/nintendo/index')
        "/projects/lg-firmwares"(controller: 'lg')
        "/ads.txt"(controller: 'home', action: 'ads')
        "/robots.txt"(controller: 'home', action: 'robot')
        "/sitemap.xml"(controller: 'home', action: 'sitemap')

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
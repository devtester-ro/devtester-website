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
        "/BingSiteAuth.xml"(controller: 'home', action: 'bing')
        "/yandex_7f0114fed975a742.html"(controller: 'home', action: 'yandex')
        "/nortonsw_53759460-f70e-0.html"(controller: 'home', action: 'norton')
        "/google68b5fbb6a8149f4d.html"(controller: 'home', action: 'googleSiteVerify')

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
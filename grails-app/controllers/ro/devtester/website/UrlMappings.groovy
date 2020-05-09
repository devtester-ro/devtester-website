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
        "/projects/lg-firmwares"(controller: 'lg')
        "/projects/nintendo-switch"(view: '/nintendo/index')
        "/ads.txt"(controller: 'home', action: 'ads')
        "/robots.txt"(controller: 'home', action: 'robot')
        "/sitemap.xml"(controller: 'home', action: 'sitemap')
        "/BingSiteAuth.xml"(controller: 'home', action: 'bing')
        "/yandex_7f0114fed975a742.html"(controller: 'home', action: 'yandex')
        "/nortonsw_53759460-f70e-0.html"(controller: 'home', action: 'norton')
        "/google68b5fbb6a8149f4d.html"(controller: 'home', action: 'googleSiteVerify')

        //old site links redirects
        "/index.php"(redirect: "/")
        "/about.php"(redirect: "/about")
        "/projects/lg-firmwares-download.php"(redirect: "/projects/lg-firmwares")
        "/projects/lg-firmwares/index.php"(redirect: "/projects/lg-firmwares")
        "/projects/lg-firmwares/drivers.php"(redirect: "/projects/lg-firmwares/drivers")
        "/projects/lg-firmwares/download.php"(redirect: "/projects/lg-firmwares#all-download")
        "/projects/lg-firmwares/install.php"(redirect: "/projects/lg-firmwares/install")
        "/projects/lg-firmwares/mlt.php"(redirect: "/projects/lg-firmwares/mlt")
        "/projects/lg-firmwares/fast-dormancy.php"(redirect: "/projects/lg-firmwares/fast-dormancy")
        "/projects/lg-firmwares/country-selection.php"(redirect: "/projects/lg-firmwares")
        "/projects/lg-firmwares/country.php"(redirect: "/projects/lg-firmwares")
        "/projects/lg-firmwares/wallpapers.php"(redirect: "/projects/lg-firmwares")
        "/projects"(redirect: "/")
        "/projects/services/imei.php"(redirect: "/projects/lg-firmwares#imei")
        "/projects/services/get-firmwares.php"(redirect: "/projects/lg-firmwares#imei")
        "/projects/nintendo-switch/index.php"(redirect: "/projects/nintendo-switch")

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
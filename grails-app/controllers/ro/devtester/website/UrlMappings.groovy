package ro.devtester.website

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: '/index')
        "/about" (view: '/home/about')
        "/projects/lg-firmwares" (view: '/lg/index')
        "/projects/lg-firmwares/install"(view: '/lg/install')
        "/projects/lg-firmwares" (controller: 'lg')
        "500"(view: '/error')
        "404"(view: '/notFound')
        "/ads.txt"(controller: 'home', action: 'adstxt')
    }
}
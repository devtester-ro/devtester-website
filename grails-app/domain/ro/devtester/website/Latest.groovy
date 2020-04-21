package ro.devtester.website

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Latest {

    String model
    String swversion
    String buyer
    String region
    String country
    String buyer_name
    Date date

    static constraints = {
        swversion nullable: true
        buyer_name nullable: true
    }
}

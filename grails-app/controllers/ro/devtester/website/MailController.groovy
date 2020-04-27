package ro.devtester.website

import com.megatome.grails.RecaptchaService

class MailController {

    def mailService
    RecaptchaService recaptchaService

    def sendMail(params) {
        try {
            def recaptchaOK = true
            if (!recaptchaService.verifyAnswer(session, request.getRemoteAddr(), params)) {
                recaptchaOK = false
            }
            if (recaptchaOK) {
                recaptchaService.cleanUp(session)
                mailService.sendMail {
                    to "levelik@yahoo.com"
                    from "${params?.email}"
                    subject "${params?.name}"
                    body "${params?.message}"
                }
                redirect(uri: "/")
            } else {
                redirect(uri: "/")
            }
        } catch (Exception e) {
            log.info("Something wrong here: " + e.getCause())
            redirect(uri: "/")
        }

    }
}

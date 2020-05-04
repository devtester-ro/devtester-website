<!-- IMEI SECTION -->
<div class="imei" id="subscribe">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h3 id="imei" class="heading" data-scrollreveal="enter left after 0s over 1s">Enter your phone
                IMEI/ESN here:</h3>
                <g:form controller="lg"
                        class="form-inline form_alt subscribe__form">
                    <label class="sr-only">IMEI</label>

                    <div class="form-group">
                        <g:textField type="text" class="form-control input-lg"
                                     placeholder="Type IMEI from Dialer - *#06#" required="" size="40"
                                     pattern="[0-9]{15}"
                                     maxlength="15" name="esn" value="${esn}"/>
                    </div>

                    <div class="btn">
                        Crypto.com - <g:link
                                uri="https://platinum.crypto.com/r/dnwq25ptdh"
                                target="_blank">Support me and get free $50 USD</g:link>
                        <recaptcha:ifEnabled>
                            <recaptcha:recaptcha includeScript="false"/>
                        </recaptcha:ifEnabled>
                    </div>
                    <br><br>
                    <g:actionSubmit class="btn btn-primary wow fadeInLeft animated animated" value="Submit"
                                    action="getFirmwareByImei"/>
                </g:form>
                <recaptcha:script/>
                <br><br>
            </div>
        </div>
        <!-- / .row -->
    </div>
    <!-- / .container -->
</div>
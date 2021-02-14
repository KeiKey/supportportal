package com.supportportal.api.v1.utlity;

public class JwtTokenProvider {

    /**TODO:
     * How should i use the secret var
     * Research where should I save the secret?
     * If the secret should be bundled with apk?
     */
    private final String secret = "KeiTestSecret12345!@[]";

    public String generateJwtToken () {
        return "test";
    }

}

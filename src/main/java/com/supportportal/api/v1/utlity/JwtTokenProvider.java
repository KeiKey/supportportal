package com.supportportal.api.v1.utlity;

import com.auth0.jwt.JWT;
import com.supportportal.api.v1.model.UserPrincipal;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.supportportal.api.v1.constant.SecurityConstant.*;

public class JwtTokenProvider {

    /**TODO:
     * How should i use the secret var
     * Research where should I save the secret?
     * If the secret should be bundled with apk?
     */
    private final String secret = "KeiTestSecret12345!@[]";

    /**TODO:
     * Find other jwt tokens options
     */
    public String generateJwtToken (UserPrincipal userPrincipal) {
        String[] claims = getClaimsFromUser(userPrincipal);
        return JWT.create()
                .withIssuer(GET_ARRAYS_KEI)
                .withAudience(GET_ARRAYS_ADMINISTRATION)
                .withIssuedAt(new Date())
                .withSubject(userPrincipal.getUsername())
                .withArrayClaim(AUTHORITIES, claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(secret.getBytes()));
    }

    private String[] getClaimsFromUser(UserPrincipal userPrincipal) {
        List<String> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : userPrincipal.getAuthorities()){
            authorities.add(grantedAuthority.getAuthority());
        }
        return authorities.toArray(new String[0]);
    }

}

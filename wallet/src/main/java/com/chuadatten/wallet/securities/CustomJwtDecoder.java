package com.chuadatten.wallet.securities;

import java.text.ParseException;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Service;

import com.chuadatten.wallet.exceptions.CustomException;
import com.chuadatten.wallet.exceptions.ErrorCode;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomJwtDecoder implements JwtDecoder {

    public Jwt decode(String token) throws JwtException {
        try {
            JWT jwt = JWTParser.parse(token);
            if (jwt.getJWTClaimsSet().getIssuer() != null) {
                String issuer = jwt.getJWTClaimsSet().getIssuer();
                if (issuer.contains("google")) {
                    return this.googleJwtDecoder().decode(token);
                }
            }

            return this.jwtDecoder().decode(token);
        } catch (ParseException var4) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
    }

    private JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("http://localhost:8081/api/v1/oauth2/jwks")
                .build();
    }

    private JwtDecoder googleJwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("https://www.googleapis.com/oauth2/v3/certs").build();
    }
}

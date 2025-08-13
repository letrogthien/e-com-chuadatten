package com.chuadatten.user.jwt;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import com.chuadatten.user.common.TokenType;
import com.chuadatten.user.entity.UserAuth;

public interface JwtTokenFactory {
    String createToken(UserAuth user, TokenType tokenType) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;

    String createToken(Map<String, Object> extraClaims, UserAuth user, TokenType tokenType) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException;

    boolean isTokenValid(String token, TokenType tokenType);

    Map<String, Object> extractClaims(String token);

    String extractClaim(String token, String claim);
}
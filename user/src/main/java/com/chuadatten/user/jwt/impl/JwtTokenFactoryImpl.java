package com.chuadatten.user.jwt.impl;

import com.chuadatten.user.common.TokenType;
import com.chuadatten.user.entity.UserAuth;
import com.chuadatten.user.exceptions.CustomException;
import com.chuadatten.user.exceptions.ErrorCode;
import com.chuadatten.user.jwt.JwtTokenConfig;
import com.chuadatten.user.jwt.JwtTokenFactory;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.*;

@Component
@RequiredArgsConstructor
public class JwtTokenFactoryImpl implements JwtTokenFactory {
    private final JwtTokenConfig config;
    private final RSAPrivateKey privateKey;

    public String createToken(UserAuth user, TokenType tokenType)
    {
        return this.createToken(new HashMap<>(), user, tokenType);
    }

    public String createToken(Map<String, Object> extraClaims, UserAuth user, TokenType tokenType)
    {
        List<String> authorities = this.getAuthorities(user);
        extraClaims.put("sub", user.getEmail());
        extraClaims.put("roles", authorities);
        extraClaims.put("id", user.getId());
        extraClaims.put("jti", UUID.randomUUID().toString());
        extraClaims.put("email", user.getEmail());
        extraClaims.put("status", user.getStatus());
        extraClaims.put("type", tokenType.toString());
        extraClaims.put("kycStatus", user.getIsKyc());
        if (tokenType == TokenType.ACCESS_TOKEN) {
            return Jwts.builder()
                    .setClaims(extraClaims)
                    .setSubject(user.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + this.getExpiration(tokenType)))
                    .setHeaderParam("kid", "auth-key-001")
                    .signWith(privateKey, SignatureAlgorithm.RS256)
                    .compact();
        }

        SecretKey key = this.getSecretKey(tokenType);
        long expiration = this.getExpiration(tokenType);
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public boolean isTokenValid(String token, TokenType tokenType) {
        try {
            SecretKey key = this.getSecretKey(tokenType);
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception var4) {
            return false;
        }
    }

    public Map<String, Object> extractClaims(String token) {
        try {
            JWT jwt = JWTParser.parse(token);
            return jwt.getJWTClaimsSet().getClaims();
        } catch (Exception var3) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
    }

    public String extractClaim(String token, String claim) {
        Map<String, Object> claims = this.extractClaims(token);
        if (claims.containsKey(claim)) {
            return claims.get(claim).toString();
        } else {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
    }

    private List<String> getAuthorities(UserAuth user) {
        return user.getUserRoles().stream().map(role ->
                role.getRole().getName()
        ).toList();
    }

    private SecretKey getSecretKey(TokenType tokenType) {
        JwtTokenConfig.TokenConfig tokenConfig = this.config.getTokenConfig(tokenType);
        byte[] keyBytes = Base64.getDecoder().decode(tokenConfig.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private long getExpiration(TokenType tokenType) {
        return this.config.getTokenConfig(tokenType).getExpiration();
    }
}

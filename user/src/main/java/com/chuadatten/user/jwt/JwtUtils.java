package com.chuadatten.user.jwt;

import com.chuadatten.user.common.TokenType;
import com.chuadatten.user.entity.UserAuth;
import com.chuadatten.user.exceptions.CustomException; // Assuming you have a CustomException
import com.chuadatten.user.exceptions.ErrorCode;   // And an ErrorCode enum/class
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
@RequiredArgsConstructor
public class JwtUtils {
    private final JwtTokenFactory jwtTokenFactory;

    public String generateToken(UserAuth user){
        try {
            return this.jwtTokenFactory.createToken(user, TokenType.ACCESS_TOKEN);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CustomException(ErrorCode.TOKEN_GENERATION_FAILED);
        }
    }

    public String generateRefreshToken(UserAuth user) {
        try {
            return this.jwtTokenFactory.createToken(user, TokenType.REFRESH_TOKEN);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CustomException(ErrorCode.TOKEN_GENERATION_FAILED);
        }
    }

    public String generateTmpToken(UserAuth user) {
        try {
            return this.jwtTokenFactory.createToken(user, TokenType.TMP_TOKEN);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CustomException(ErrorCode.TOKEN_GENERATION_FAILED);
        }
    }

    public String generateActivationToken(UserAuth user) {
        try {
            return this.jwtTokenFactory.createToken(user, TokenType.ACTIVATION_TOKEN);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CustomException(ErrorCode.TOKEN_GENERATION_FAILED);
        }
    }

    public String generateResetPasswordToken(UserAuth user) {
        try {
            return this.jwtTokenFactory.createToken(user, TokenType.PASSWORD_RESET_TOKEN);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CustomException(ErrorCode.TOKEN_GENERATION_FAILED);
        }
    }

    public boolean isTokenValid(String token, TokenType tokenType) {
        return this.jwtTokenFactory.isTokenValid(token, tokenType);
    }

    public String extractClaim(String token, String claim) {
        return this.jwtTokenFactory.extractClaim(token, claim);
    }
}
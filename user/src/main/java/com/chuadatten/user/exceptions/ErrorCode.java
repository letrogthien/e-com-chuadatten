package com.chuadatten.user.exceptions;



import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public enum ErrorCode {
    UNAUTHORIZED("E001", "Unauthorized", HttpStatus.UNAUTHORIZED), 
    INVALID_CLAIM("E002", "Invalid claim", HttpStatus.UNAUTHORIZED), 
    USER_NOT_FOUND("E003", "User not found", HttpStatus.NOT_FOUND), 
    INVALID_TOKEN("E004", "Invalid token", HttpStatus.UNAUTHORIZED), 
    TOKEN_GENERATION_FAILED("E005", "Token generation failed", HttpStatus.UNAUTHORIZED), 
    ROLE_NOT_FOUND("E006", "Role not found", HttpStatus.NOT_FOUND), 
    PASSWORD_MISMATCH("E007", "Password mismatch", HttpStatus.BAD_REQUEST), 
    PASSWORDS_DO_NOT_MATCH("E008", "Passwords do not match", HttpStatus.BAD_REQUEST), 
    PASSWORD_RECENTLY_USED("E009", "Password recently used", HttpStatus.BAD_REQUEST),
    ACCESS_DENIED("E010", "Access denied", HttpStatus.FORBIDDEN),
    INVALID_INPUT("E011", "Invalid input", HttpStatus.BAD_REQUEST),
    NOT_FOUND("E012", "Not found", HttpStatus.NOT_FOUND), 
    NOT_KYC("E013", "Not KYC", HttpStatus.BAD_REQUEST),
    ;

    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}

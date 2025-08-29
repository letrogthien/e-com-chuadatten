package com.chuadatten.wallet.vnpay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "vnpay")
@Getter
@Setter
public class PayConfig {
    private String vnpVersion;
    private String vnpCommand;
    private String vnpTmnCode;
    private String vnpHashSecret;
    private String vnpHashType;
    private String vnpReturnUrl;
    private String vnpBankCode;
    private String vnpPayUrl;

}
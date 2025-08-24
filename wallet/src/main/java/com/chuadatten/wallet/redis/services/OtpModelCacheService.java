package com.chuadatten.wallet.redis.services;

import com.chuadatten.wallet.otp.OtpModel;
import com.chuadatten.wallet.otp.OtpType;
import com.chuadatten.wallet.redis.OtpRedisTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class OtpModelCacheService {
    private final OtpRedisTemplate redisTemplate;

    private String generateOtpCacheKey(UUID userId, String otp, OtpType otpType) {
        return "otp:" + otp + ":" + otpType.toString() + ":" + userId.toString();
    }

    public void saveOtpModel(OtpModel otpModel) {
        String key = this.generateOtpCacheKey(otpModel.getUserId(), otpModel.getOtp(), otpModel.getOtpType());
        this.redisTemplate.opsForValue().set(key, otpModel);
        this.redisTemplate.expire(key, 5L, TimeUnit.MINUTES);
    }

    public boolean isPresentAndValidInCache(UUID userId, String otp, OtpType otpType) {
        String key = this.generateOtpCacheKey(userId, otp, otpType);
        OtpModel otpModel = this.redisTemplate.opsForValue().get(key);
        if (otpModel == null) {
            return false;
        }
        this.redisTemplate.delete(key);
        return true;
    }

}

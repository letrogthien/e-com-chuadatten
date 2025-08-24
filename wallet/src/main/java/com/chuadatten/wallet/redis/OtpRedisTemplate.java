package com.chuadatten.wallet.redis;

import com.chuadatten.wallet.otp.OtpModel;
import org.springframework.data.redis.core.RedisTemplate;

public class OtpRedisTemplate extends RedisTemplate<String, OtpModel> {
}

package com.chuadatten.transaction.redis;

import com.chuadatten.transaction.otp.OtpModel;
import org.springframework.data.redis.core.RedisTemplate;

public class OtpRedisTemplate extends RedisTemplate<String, OtpModel> {
}

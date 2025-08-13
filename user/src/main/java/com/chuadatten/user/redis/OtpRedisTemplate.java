package com.chuadatten.user.redis;

import com.chuadatten.user.otp.OtpModel;
import org.springframework.data.redis.core.RedisTemplate;

public class OtpRedisTemplate extends RedisTemplate<String, OtpModel> {
}

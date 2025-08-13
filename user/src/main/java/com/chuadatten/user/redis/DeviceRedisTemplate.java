package com.chuadatten.user.redis;


import com.chuadatten.user.entity.TrustingDevice;
import org.springframework.data.redis.core.RedisTemplate;


public class DeviceRedisTemplate extends RedisTemplate<String, TrustingDevice> {
}

package com.chuadatten.user.redis;

import com.chuadatten.user.entity.WhiteList;
import org.springframework.data.redis.core.RedisTemplate;

public class WhiteListTemplate extends RedisTemplate<String, WhiteList> {
}

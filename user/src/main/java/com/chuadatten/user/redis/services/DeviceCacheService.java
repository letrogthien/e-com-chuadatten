package com.chuadatten.user.redis.services;

import com.chuadatten.user.common.Status;
import com.chuadatten.user.entity.TrustingDevice;
import com.chuadatten.user.redis.DeviceRedisTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class DeviceCacheService {
    private final DeviceRedisTemplate deviceRedisTemplate;

    public String generateDeviceCacheKey(UUID userId, UUID deviceInformationId) {
        String var10000 = String.valueOf(userId);
        return "trusting-device:" + var10000 + ":" + deviceInformationId;
    }

    public void saveToCache(UUID userId, UUID deviceInformationId) {
        String key = this.generateDeviceCacheKey(userId, deviceInformationId);
        TrustingDevice trustingDevice = new TrustingDevice();
        trustingDevice.setUserId(userId);
        trustingDevice.setDeviceInformationId(deviceInformationId);
        trustingDevice.setStatus(Status.PENDING);
        this.deviceRedisTemplate.opsForValue().set(key, trustingDevice);
        this.deviceRedisTemplate.expire(key, 10L, TimeUnit.MINUTES);
    }

    public boolean isPresentInCache(UUID userId, UUID deviceInformationId) {
        String key = this.generateDeviceCacheKey(userId, deviceInformationId);
        return this.deviceRedisTemplate.hasKey(key);
    }

    public void deleteFromCache(UUID userId, UUID deviceInformationId) {
        String key = this.generateDeviceCacheKey(userId, deviceInformationId);
        this.deviceRedisTemplate.delete(key);
    }


}

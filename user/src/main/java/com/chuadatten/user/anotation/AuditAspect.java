package com.chuadatten.user.anotation;

import com.chuadatten.user.entity.AuditLog;
import com.chuadatten.user.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspect {

    private final AuditLogRepository auditLogRepository;

    @Around("@annotation(com.chuadatten.user.anotation.CusAuditable)")
    public Object logAudit(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CusAuditable auditAnnotation = method.getAnnotation(CusAuditable.class);
        String action = auditAnnotation.action();
        String description = auditAnnotation.description();
        UUID userId = null;
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            if ("userId".equals(parameterNames[i]) && args[i] instanceof UUID uuid) {
                userId = uuid;
                break;
            }

        }
        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(userId);
        auditLog.setAction(action);
        auditLog.setDescription(description);
        auditLogRepository.save(auditLog);
        return joinPoint.proceed();
    }
}
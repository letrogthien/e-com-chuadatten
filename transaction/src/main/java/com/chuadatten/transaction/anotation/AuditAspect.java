package com.chuadatten.transaction.anotation;

import com.chuadatten.transaction.entity.AuditLog;
import com.chuadatten.transaction.repository.AuditLogReposiroty;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@RequiredArgsConstructor
public class AuditAspect {

    private final AuditLogReposiroty auditLogRepository;

    @Around("@annotation(com.chuadatten.transaction.anotation.CusAuditable)")
    public Object logAudit(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CusAuditable auditAnnotation = method.getAnnotation(CusAuditable.class);
        String action = auditAnnotation.action();
        String description = auditAnnotation.description();
        String userId = null;
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < parameterNames.length; i++) {
            if ("userId".equals(parameterNames[i]) && args[i] instanceof String uuid) {
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
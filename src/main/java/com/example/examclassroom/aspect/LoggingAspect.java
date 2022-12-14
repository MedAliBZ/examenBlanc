package com.example.examclassroom.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @After("execution(void tn.esprit.examclassroom.service.*.get*(..))")
    public void logMethodExit(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        log.info(name);
    }

}

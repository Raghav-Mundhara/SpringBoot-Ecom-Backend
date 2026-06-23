package com.ecom.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.ecom.demo.service.*.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable{
        long start=System.currentTimeMillis();
        Object obj = jp.proceed();
        long end=System.currentTimeMillis();
        LOGGER.info("Time Taken by "+jp.getSignature().getName()+" => "+ (end-start)+ "ms");
        return obj;
    }
}

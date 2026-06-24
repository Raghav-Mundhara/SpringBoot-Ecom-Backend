package com.ecom.demo.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //(return type,class_name.method_name(args))
    @Before("execution(* com.ecom.demo.service.*.*(..))")
    public void logMethod(JoinPoint jp){
        LOGGER.info("Method Called "+jp.getSignature().getName());
    }
    @After("execution(* com.ecom.demo.service.*.*(..))")
    public void logMethodAfter(JoinPoint jp){
        LOGGER.info("Method Executed "+jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.ecom.demo.service.*.*(..))")
    public void logMethodAfterThrowing(JoinPoint jp){
        LOGGER.info("Method has some issues "+jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.ecom.demo.service.*.*(..))")
    public void logMethodAfterReturning(JoinPoint jp){
        LOGGER.info("Method Executed Successfully "+jp.getSignature().getName());
    }
}

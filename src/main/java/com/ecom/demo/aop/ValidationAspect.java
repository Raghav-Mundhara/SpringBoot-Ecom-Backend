package com.ecom.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.ecom.demo.service.ProductService.getProductById(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable{
        LOGGER.info("Inside Validation Aspect");
        if(postId<0){
            LOGGER.info("Updating postId into positive value");
            postId = -postId;
        }
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }
}

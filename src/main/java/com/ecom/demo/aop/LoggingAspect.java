package com.ecom.demo.aop;


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
    @Before("execution(* *.*(..)")
    public void logMethod(){
        LOGGER.info("Method Called");
    }
}

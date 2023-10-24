package com.in28minutes.learnspringapp.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    // 명시한 패키지에 존재하는 빈으로 들어가는 메소드 호출을 인터셉트하라는 실행명령 //
    // execution(* com.in28minutes.learnspringapp.aopexample.business.*.*(..))
    @Before("execution(* com.in28minutes.learnspringapp.aopexample.data.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Before Aspect - Method is called -> {}",joinPoint);
    }
}

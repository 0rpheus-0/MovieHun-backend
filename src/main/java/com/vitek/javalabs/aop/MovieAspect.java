package com.vitek.javalabs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class MovieAspect {

    @Pointcut("execution(* com.vitek.javalabs.service.MovieService.*(..))")
    public void movieServiceMethods() {
    }

    @Before("movieServiceMethods()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Entering method: {}", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "movieServiceMethods()", returning = "result")
    public void afterReturningAdvice(
            final JoinPoint joinPoint, final Object result) {
        log.info("Exiting method: {}, with result: {}",
                joinPoint.getSignature().getName(), result.toString());
    }

    @After("movieServiceMethods()")
    public void afterAdvice(final JoinPoint joinPoint) {
        log.info("Method: {} has completed",
                joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "movieServiceMethods()", throwing = "ex")
    public void afterThrowingAdvice(
            final JoinPoint joinPoint, final Throwable ex) {
        log.error("Exception thrown in method: {} - Error: {}",
                joinPoint.getSignature().getName(),
                ex.getClass().getSimpleName(), ex);
    }

}

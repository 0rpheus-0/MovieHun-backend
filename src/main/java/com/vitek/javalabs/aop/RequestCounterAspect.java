package com.vitek.javalabs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.vitek.javalabs.service.RequestCounterService;

@Aspect
@Component
class RequestCounterAspect {
    RequestCounterService requestCounterService;

    public RequestCounterAspect(RequestCounterService requestCounterService) {
        this.requestCounterService = requestCounterService;
    }

    @Around("@within(com.vitek.javalabs.aop.RequestStats) ||"
            + " @annotation(com.vitek.javalabs.aop.RequestStats)")
    public Object incrementRequestStats(ProceedingJoinPoint joinPoint) throws Throwable {
        requestCounterService.increment();
        return joinPoint.proceed();
    }
}

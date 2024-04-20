package com.vitek.javalabs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class DirectorAspect extends AbstractAspect {

    @Pointcut("execution(* com.vitek.javalabs.service.DirectorService.*(..))")
    public void setPointcut() {
    }
}

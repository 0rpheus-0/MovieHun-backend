package com.vitek.javalabs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class YearAspect extends AbstractAspect {

    @Pointcut("execution(* com.vitek.javalabs.service.YearService.*(..))")
    public void setPointcut() {
    }

}

package com.vitek.javalabs.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GenreAspect extends AbstractAspect {

    @Pointcut("execution(* com.vitek.javalabs.service.GenreService.*(..))")
    public void setPointcut() {
    }

}

package com.ehome.spring_aop.annotation.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 在定义一个切面的时候，首先要定义成bean(@Component),
 * 再使用@aspect 定义一个切面类
 */
@Component
@Aspect
public class BeforeAdvice {

    @Pointcut("execution(* com.ehome.spring_aop.annotation.service.impl.*.*(..))")
    private void anyServiceMethod() {}

    /**
     * 匹配 com.ehome.spring_aop.annotation.service.impl 包下所有类的所有方法作为切入点
     */
    @Before(value = "anyServiceMethod()")
    public void authorith() {
        System.out.println("LogAspect.authorith()...");
    }

    @After(value = "anyServiceMethod()")
    public void afterMethod() {
        System.out.println("LogAspect.afterMethod()...");
    }
}

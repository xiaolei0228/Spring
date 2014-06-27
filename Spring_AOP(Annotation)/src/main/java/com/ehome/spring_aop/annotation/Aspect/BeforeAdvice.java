package com.ehome.spring_aop.annotation.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package com.ehome.spring_aop.annotation.Aspect
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/6/27 0027 23:11
 * @Copyright: 2014 ihome.com
 */
// 使用@Aspect 定义一个切面类
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
}

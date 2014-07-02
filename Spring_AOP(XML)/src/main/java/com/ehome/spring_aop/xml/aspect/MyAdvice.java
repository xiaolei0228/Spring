package com.ehome.spring_aop.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @version V1.0
 * @Project: Spring
 * @Title: 基于xml的一个切面bean
 * @Package com.ehome.spring_aop.xml.aspect
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/7/2 0002 22:40
 * @Copyright: 2014 ihome.com
 */
public class MyAdvice {

    public void beforeMethod() {
        System.out.println("XML方式的切面类：MyAdvice.beforeMethod()");
    }

    public void afterMethod() {
        System.out.println("XML方式的切面类：MyAdvice.afterMethod()");
    }

    public void afterReturningMethod() {
        System.out.println("XML方式的切面类：MyAdvice.afterReturningMethod()");
    }

    public void afterThrowingMethod() {
        System.out.println("XML方式的切面类：MyAdvice.afterThrowingMethod()");
    }

    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("XML方式的切面类：MyAdvice.aroundMethod() 开始...");
        Object rvt = joinPoint.proceed();
        System.out.println("XML方式的切面类：MyAdvice.aroundMethod() 结束...  返回值\t" + rvt);
    }
}

package com.ehome.spring_aop.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 在定义一个切面的时候，首先要定义成bean(@Component),
 * 再使用@aspect 定义一个切面类
 */
@Component
@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.ehome.spring_aop.annotation.service.impl.*.*(..))")
    private void anyServiceMethod() {}

    /**
     * 匹配 com.ehome.spring_aop.annotation.service.impl 包下所有类的所有方法作为切入点
     */
    @Before(value = "anyServiceMethod()")
    public void beforeMethod() {
        System.out.println("LogAspect.beforeMethod()...");
    }

    /**
     * After 增强处理不管目标方法如何结束（保存成功完成和遇到异常中止两种情况）,它都会被织入
     */
    @After(value = "anyServiceMethod()")
    public void afterMethod() {
        System.out.println("LogAspect.afterMethod()...");
    }

    /**
     * AfterReturning 处理只有在目标方法【成功】完成后才会被织入
     * @param rvt 目标方法的返回值
     */
    @AfterReturning(returning = "rvt", pointcut = "anyServiceMethod()")
    public void afterReturningInvokeMethod(Object rvt) {
        System.out.println("目标方法成功返回值：" + rvt);
    }

    /**
     * AfterThrowing 处理只有在目标方法抛出异常时才会被织入执行
     * @param e 目标方法抛出的异常
     */
    @AfterThrowing(throwing = "e", pointcut = "anyServiceMethod()")
    public void afterThrowingInvokeMethod(Throwable e) {
        System.out.println("目标方法抛出了异常：" + e);
    }

    /**
     * Around 增强处理近似等于 Before 增强处理和  AfterReturning 增强处理的总和。
     * 它可改变执行目标方法的参数值，也可改变目标方法之后的返回值
     * @param joinPoint 连接点
     *
     * 注：@Around与@Before和@After不能同时使用
     */
//    @Around(value = "anyServiceMethod()")
//    public void aroundProcessTx(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("执行目标方法之前，模拟开启事务...");
//        // 执行目标方法，并保存目标方法返回值
//        Object rvt = joinPoint.proceed();
//        System.out.println("执行目标方法之后，模拟关闭事务...\t  返回值：" + rvt);
//    }


}

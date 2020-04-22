package com.nubo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description 日志拦截
 * @author liubin
 * @date 20/4/21 11:45
 */
@Aspect
@Component
@Order(2)
public class LogAspect {

    @Pointcut("execution(public * com.nubo.jfs.service.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint point) {
        long t1 = System.currentTimeMillis();
        System.out.println("日志记录开始");
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("日志记录结束,耗时：" + (t2 - t1) + "ms");
    }

    @Before("pointcut()")
    public void beginTransaction() {
        System.out.println("before beginTransaction");
    }

    @After("pointcut()")
    public void commit() {
        System.out.println("after commit");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "returnObject")
    public void afterReturning(JoinPoint joinPoint, Object returnObject) {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing afterThrowing  rollback");
    }



}

package com.nubo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description 权限拦截
 * @author liubin
 * @date 20/4/21 15:28
 */
@Aspect
@Component
@Order(1)
public class AuthAspect {

    @Pointcut(value = "@annotation(auth)", argNames = "auth")
    public void pointcut(Auth auth) {
    }

    @Around(value = "pointcut(auth)", argNames = "joinPoint,auth")
    public void aroung(ProceedingJoinPoint joinPoint, Auth auth) {
        if (auth.hasAuth()) {
            System.out.println("have auth...");
            try {
                joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } else {
            System.out.println("not have auth...");
        }


    }
}

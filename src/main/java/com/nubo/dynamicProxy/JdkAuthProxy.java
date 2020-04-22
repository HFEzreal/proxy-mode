package com.nubo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description 代理类
 * @author liubin
 * @date 20/4/21 10:19
 */
public class JdkAuthProxy implements InvocationHandler {

    //被代理的对象
    private Object target;
    private boolean hasAuth = true;

    public JdkAuthProxy(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  代理对象
     * @param method  增强的方法
     * @param args 方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("判断权限开始");
        Object result = null;
        if (hasAuth) {
            result = method.invoke(target, args);
        }
        System.out.println("判断权限结束");
        return result;
    }
}

package com.nubo.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description jdk动态代理
 * @author liubin
 * @date 20/4/21 10:19
 */
public class JdkLogProxy implements InvocationHandler {
    //被代理的对象
    private Object target;
    public JdkLogProxy(Object target) {
        this.target = target;
    }
    /**
     * @param proxy  代理对象
     * @param method  增强的方法
     * @param args 方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long t1 = System.currentTimeMillis();
        System.out.println("日志记录开始");
        Object result = method.invoke(target, args);
        long t2 = System.currentTimeMillis();
        System.out.println("日志记录结束,耗时：" + (t2 - t1) + "ms");
        return result;
    }
}

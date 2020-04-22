package com.nubo.dynamicProxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description cglib动态代理
 * @author liubin
 * @date 20/4/21 11:11
 */
public class CglibLogProxy implements MethodInterceptor {
    /**
     * @param object 需要增强的对象
     * @param method 表示拦截的方法
     * @param objects 数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long、double-->Double
     * @param methodProxy 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return java.lang.Object
     */
    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long t1 = System.currentTimeMillis();
        System.out.println("日志记录开始");
        Object result = methodProxy.invokeSuper(object, objects);
        long t2 = System.currentTimeMillis();
        System.out.println("日志记录结束,耗时：" + (t2 - t1) + "ms");
        return result;
    }
}

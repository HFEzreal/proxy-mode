package com.nubo.dynamicProxy;

import com.nubo.service.DrugServiceImpl;
import com.nubo.service.TakeService;
import com.nubo.util.ProxyUtils;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

class TakeServiceTest {

    @Test
    void JdkLogProxyTakeIn() {
        InvocationHandler logHandler = new JdkLogProxy(new DrugServiceImpl());
        TakeService takeService = (TakeService) Proxy.newProxyInstance(TakeService.class.getClassLoader(), // 加载接口的类加载器
                new Class[]{TakeService.class}, // 一组接口
                logHandler); // 自定义的InvocationHandler
        takeService.takeIn();
        //生成动态代理生成的类
        ProxyUtils.generateClassFile(DrugServiceImpl.class, "DrugServiceImplProxy");
    }

    @Test
    void JdkLogAuthProxyTakeIn() {
        InvocationHandler logHandler = new JdkLogProxy(new DrugServiceImpl());
        TakeService takeLogService = (TakeService) Proxy.newProxyInstance(TakeService.class.getClassLoader(), // 加载接口的类加载器
                new Class[]{TakeService.class}, // 一组接口
                logHandler); // 自定义的InvocationHandler
        InvocationHandler authHandler = new JdkAuthProxy(takeLogService);
        TakeService takeAuthService = (TakeService) Proxy.newProxyInstance(TakeService.class.getClassLoader(), // 加载接口的类加载器
                new Class[]{TakeService.class}, // 一组接口
                authHandler); // 自定义的InvocationHandler
        takeAuthService.takeIn();
        //生成动态代理生成的类
        ProxyUtils.generateClassFile(DrugServiceImpl.class, "DrugServiceImplProxy2");
    }

    @Test
    void CglibLogProxyTakeIn() {
        // 生成class类的路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://svn-sources/local-sources/jfs/target/classes");

        CglibLogProxy cglibLogProxy = new CglibLogProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DrugServiceImpl.class);  // 设置超类，cglib是通过继承来实现的
        enhancer.setCallback(cglibLogProxy);
        DrugServiceImpl logService = (DrugServiceImpl) enhancer.create();
        logService.takeIn();
    }

}

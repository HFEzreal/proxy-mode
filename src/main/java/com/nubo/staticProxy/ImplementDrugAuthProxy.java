package com.nubo.staticProxy;

import com.nubo.service.TakeService;

/**
 * @description 权限控制
 * @author liubin
 * @date 20/4/21 09:50
 */
public class ImplementDrugAuthProxy implements TakeService {

    private TakeService takeService;

    private boolean hasAuth = true;

    public ImplementDrugAuthProxy(TakeService takeService) {
        this.takeService = takeService;
    }

    @Override
    public void takeIn() {
        System.out.println("判断权限开始");
        if (hasAuth) {
            takeService.takeIn();
        }
        System.out.println("判断权限结束");
    }

    @Override
    public void takeOut() {
        System.out.println("判断权限开始");
        if (hasAuth) {
            takeService.takeOut();
        }
        System.out.println("判断权限结束");
    }
}

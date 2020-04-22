package com.nubo.staticProxy;

/**
 * @description 权限控制
 * @author liubin
 * @date 20/4/21 09:33
 */
public class ExtendDrugAuthProxy extends ExtendDrugLogProxy {

    private boolean hasAuth = true;

    public ExtendDrugAuthProxy() {
    }

    @Override
    public void takeIn() {
        System.out.println("判断权限开始");
        if (hasAuth) {
            super.takeIn();
        }
        System.out.println("判断权限结束");
    }
}

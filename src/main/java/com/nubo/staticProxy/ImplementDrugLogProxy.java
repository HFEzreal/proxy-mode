package com.nubo.staticProxy;

import com.nubo.service.TakeService;

/**
 * @description 日志记录
 * @author liubin
 * @date 20/4/21 09:50
 */
public class ImplementDrugLogProxy implements TakeService {

    private TakeService takeService;

    public ImplementDrugLogProxy(TakeService takeService) {
        this.takeService = takeService;
    }

    @Override
    public void takeIn() {
        long t1 = System.currentTimeMillis();
        System.out.println("日志记录开始");
        takeService.takeIn();
        long t2 = System.currentTimeMillis();
        System.out.println("日志记录结束,耗时：" + (t2 - t1) + "ms");
    }

    @Override
    public void takeOut() {
        long t1 = System.currentTimeMillis();
        System.out.println("日志记录开始");
        takeService.takeOut();
        long t2 = System.currentTimeMillis();
        System.out.println("日志记录结束,耗时：" + (t2 - t1) + "ms");
    }
}

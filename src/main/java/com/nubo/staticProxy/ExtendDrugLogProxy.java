package com.nubo.staticProxy;

import com.nubo.service.DrugServiceImpl;

/**
 * @description 日志记录
 * @author liubin
 * @date 20/4/21 09:33
 */
public class ExtendDrugLogProxy extends DrugServiceImpl {

    @Override
    public void takeIn() {
        long t1 = System.currentTimeMillis();
        System.out.println("日志记录开始");
        super.takeIn();
        long t2 = System.currentTimeMillis();
        System.out.println("日志记录结束,耗时：" + (t2 - t1) + "ms");
    }
}

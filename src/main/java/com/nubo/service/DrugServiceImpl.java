package com.nubo.service;

import org.springframework.stereotype.Service;

/**
 * @description 拿药
 * @author liubin
 * @date 20/4/21 09:22
 */
@Service
public class DrugServiceImpl implements TakeService {
    @Override
    public void takeIn() {
        // 补药
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("take in drug...");
    }

    @Override
    public void takeOut() {
        // 拿药
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("take out drug...");
    }
}

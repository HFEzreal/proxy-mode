package com.nubo.service;

import com.nubo.aop.Auth;
import org.springframework.stereotype.Service;

/**
 * @description 拿耗材
 * @author liubin
 * @date 20/4/21 09:22
 */
@Service
public class SupplyServiceImpl implements TakeService {

    @Override
    @Auth
    public void takeIn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("take in supply...");
    }

    @Override
    @Auth(hasAuth = false)
    public void takeOut() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("take out supply...");
    }
}

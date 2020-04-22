package com.nubo;

import com.nubo.service.DrugServiceImpl;
import com.nubo.service.SupplyServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JfsApplicationTests {

    @Autowired
    DrugServiceImpl service;
    @Autowired
    SupplyServiceImpl supplyService;

    @Test
    void contextLoads() {
        service.takeIn();
    }

    @Test
    void supplyServiceTest() {
        supplyService.takeIn();
        supplyService.takeOut();
    }

}

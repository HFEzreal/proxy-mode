package com.nubo.staticProxy;

import com.nubo.service.DrugServiceImpl;
import com.nubo.service.SupplyServiceImpl;
import com.nubo.service.TakeService;
import org.junit.jupiter.api.Test;

class TakeServiceTest {

    @Test
    void ExtendDrugLogProxyTakeIn() {
        ExtendDrugLogProxy proxy = new ExtendDrugLogProxy();
        proxy.takeIn();
    }

    @Test
    void ExtendDrugAuthProxyTakeIn() {
        ExtendDrugAuthProxy proxy = new ExtendDrugAuthProxy();
        proxy.takeIn();
    }

    @Test
    void ImplementDrugAuthProxyTakeIn() {
        TakeService proxy = new ImplementDrugAuthProxy(new DrugServiceImpl());
        proxy.takeIn();
    }

    @Test
    void ImplementDrugAuthLogProxyTakeIn() {
        TakeService authProxy = new ImplementDrugAuthProxy(new DrugServiceImpl());
        TakeService logProxy = new ImplementDrugLogProxy(authProxy);
        logProxy.takeIn();
    }

    @Test
    void ImplementDrugLogAuthProxyTakeIn() {
        TakeService logProxy= new ImplementDrugLogProxy(new SupplyServiceImpl());
        TakeService authProxy  = new ImplementDrugAuthProxy(logProxy);
        authProxy.takeIn();
    }

}

package ooconcepts.service.providers;

import csci.ooad.polymorphia.intf.PolymorphiaStrategyProvider;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import polymorphia.strategy.StrategyProvider;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {

    @Test
    void test() {
        ServiceLoader<MyService> loader = ServiceLoader.load(MyService.class);
        loader.iterator().hasNext();
        List<MyService> services = new ArrayList<>();
        for (MyService service : loader) {
            services.add(service);
            System.out.println(service.getClass().getName());
            service.doSomething();
        }
        assertTrue(services.size() > 0);
    }

    @Test
    void testProviderLoading() {
        ServiceLoader<PolymorphiaStrategyProvider> loader = ServiceLoader.load(PolymorphiaStrategyProvider.class);
        List<PolymorphiaStrategyProvider> services = new ArrayList<>();
        for (PolymorphiaStrategyProvider service : loader) {
            services.add(service);
            System.out.println(service.getClass().getName());
            service.create(null);
        }
        assertTrue(services.size() > 0);
    }

    @Test
    void testProfessorStrategyLoading() {
        StrategyProvider strategyProvider = new StrategyProvider();
        assertTrue(strategyProvider != null);
    }

}
package ooconcepts.service.providers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceTest {

    @Test
    void test() {
        ServiceLoader<MyService> loader = ServiceLoader.load(MyService.class);
        List<MyService> services = new ArrayList<>();
        for (MyService service : loader) {
            services.add(service);
            System.out.println(service.getClass().getName());
            service.doSomething();
        }
        assertTrue(services.size() > 0);
    }

}
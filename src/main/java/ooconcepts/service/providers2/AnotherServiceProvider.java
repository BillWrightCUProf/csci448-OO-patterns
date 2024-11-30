package ooconcepts.service.providers2;

import ooconcepts.service.providers.MyService;

public class AnotherServiceProvider implements MyService {

    @Override
    public void doSomething() {
        System.out.println("AnotherServiceProvider doSomething");
    }
}

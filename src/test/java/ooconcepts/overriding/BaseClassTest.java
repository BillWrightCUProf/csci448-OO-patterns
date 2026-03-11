package ooconcepts.overriding;

import org.junit.jupiter.api.Test;

class BaseClassTest {
    @Test
    void testIvarOverriding() {
        BaseClass myInstance = new Subclass("John", 20);
        System.out.println(myInstance.name + " is " + myInstance.getAge() + " years old");   // prints 10
    }
}
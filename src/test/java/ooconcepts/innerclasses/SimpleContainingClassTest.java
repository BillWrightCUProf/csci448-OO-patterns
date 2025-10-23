package ooconcepts.innerclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleContainingClassTest {

    @Test
    void testStaticInnerClass() {
        SimpleContainingClass.StaticInnerClass staticInnerClass = new SimpleContainingClass.StaticInnerClass();
        staticInnerClass.setName("TestName");
        SimpleContainingClass simpleContainingClass = staticInnerClass.getSimpleContainingClass();
        assertEquals("TestName", simpleContainingClass.getName());
    }

}
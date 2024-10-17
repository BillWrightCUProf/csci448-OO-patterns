package ooconcepts.innerclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainingClassTest {

    @Test
    void testInnerClass() {
        ContainingClass containingClass = new ContainingClass();

        ContainingClass.InnerClass innerClass = containingClass.createInnerClass();
        innerClass.setContainingClassPrivateName("NewName");
        innerClass.printNames();

        ContainingClass.AnotherInnerClass2 anotherInnerClass2 = containingClass.new AnotherInnerClass2();
    }

    @Test
    void testCreatingInnerClass() {
        ContainingClass.StaticInnerClass staticInnerClass = new ContainingClass.StaticInnerClass();
        staticInnerClass.printNames();
    }

}
package cpluspluscomparison;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperManTest {
    @Test
    void testSuperMan() {
        SuperMan superMan = new SuperMan();
        SubMan milton = new SubMan();
        System.out.println(superMan.whoAmI());
        System.out.println(milton.whoAmI());
    }
}
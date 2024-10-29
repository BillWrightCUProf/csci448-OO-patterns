package ooconcepts.encapsulation;

import org.junit.jupiter.api.Test;

public class StaticVariableTest {
    public static String MY_STATIC_VARIABLE = "MY_STATIC_VARIABLE";

    @Test
    void testStaticVariable() {
        System.out.println(MY_STATIC_VARIABLE);

        MY_STATIC_VARIABLE = "Another value";
        System.out.println(MY_STATIC_VARIABLE);

        MY_STATIC_VARIABLE = "What's static about this value?";
        System.out.println(MY_STATIC_VARIABLE);
    }
}

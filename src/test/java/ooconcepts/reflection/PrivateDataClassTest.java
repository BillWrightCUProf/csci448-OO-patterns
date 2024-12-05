package ooconcepts.reflection;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PrivateDataClassTest {

    @Test
    void testPrivateDataClass() throws NoSuchFieldException, IllegalAccessException {
        PrivateDataClass bill = new PrivateDataClass("Bill", 40 + 21);
        System.out.println(bill);

        // Not allowed by the compiler because age has private access (and we didn't define a setter)
        // privateData.age = 40;

        VarHandle PRIVATE_TEST_VARIABLE = MethodHandles
                .privateLookupIn(PrivateDataClass.class, MethodHandles.lookup())
                .findVarHandle(PrivateDataClass.class, "age", int.class);

        assertEquals(1, PRIVATE_TEST_VARIABLE.coordinateTypes().size());
        assertEquals(PrivateDataClass.class, PRIVATE_TEST_VARIABLE.coordinateTypes().get(0));

        PRIVATE_TEST_VARIABLE.set(bill, 40);
        System.out.println("Manipulated with VarHandle: " + bill);

        // TODO: Update the lecture on Encapsulation to include this
        // THIS CODE WAS DEPRECATED IN Java 9.0 and the above method is to be used.
//        Field ageField = bill.getClass().getDeclaredField("age");
//        ageField.setAccessible(true);
//        ageField.set(bill, 40);
//        System.out.println(bill);
//
//        Field f = Unsafe.class.getDeclaredField("theUnsafe");
//        f.setAccessible(true);
//        var unsafe = (Unsafe) f.get(null);
//        Field nameField = bill.getClass().getDeclaredField("name");
//
//        unsafe.putObject(bill, unsafe.objectFieldOffset(nameField), "I'm a hacker");
//        unsafe.putInt(bill, unsafe.objectFieldOffset(ageField), 22);
//        System.out.println(bill);
    }

}
package ooconcepts.reflection;

import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;


class PrivateDataClassTest {

    @Test
    void testPrivateDataClass() throws NoSuchFieldException, IllegalAccessException {
        PrivateDataClass bill = new PrivateDataClass("Bill", 40 + 21);
        System.out.println(bill);

        // Not allowed by the compiler because age has private access (and we didn't define a setter)
        // privateData.age = 40;

        Field ageField = bill.getClass().getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(bill, 40);
        System.out.println(bill);

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        var unsafe = (Unsafe) f.get(null);
        Field nameField = bill.getClass().getDeclaredField("name");

        unsafe.putObject(bill, unsafe.objectFieldOffset(nameField), "I'm a hacker");
        unsafe.putInt(bill, unsafe.objectFieldOffset(ageField), 22);
        System.out.println(bill);
    }

}
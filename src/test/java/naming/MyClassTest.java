package naming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {

    @Test
    void testCreateBasketballTeams() {
        // Create basketball teams
        List<String> ht = new MyClass().myMethod(5);
        List<String> at = new MyClass().myMethod(5);
        System.out.println(ht);
        System.out.println(at);

        assertEquals(5, ht.size());
        assertEquals(5, at.size());
    }

}
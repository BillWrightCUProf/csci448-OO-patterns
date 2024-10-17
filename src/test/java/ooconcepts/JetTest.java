package ooconcepts;

import io.cucumber.java.bs.A;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JetTest {

    @Test
    void testJetCreation() {
        Jet jet = new Jet(1000);
        assertNotNull(jet);
        assertEquals(1000, jet.getSpeed());
    }

    @Test
    void testJetSpeedChange() {
        Jet jet = new Jet(1000);
        jet.setSpeed(2000);
        assertEquals(4000, jet.getSpeed());
    }

    @Test
    void testAcceleration() {
        Jet jet = new Jet(1000);
        jet.accelerate();
        assertEquals(2000, jet.getSpeed());
        jet.accelerate();
        assertEquals(4000, jet.getSpeed());
    }

    @Test
    // Not sure when I'd use such meta programming, but it's good to know
    void testInstanceCreation() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object jet = Class.forName("ooconcepts.Jet").getDeclaredConstructor().newInstance();
        assertNotNull(jet);
        assertInstanceOf(Jet.class, jet);
        System.out.println(jet);
    }

    @Test
    void testDefaultConstructor() {
        Jet jet = new Jet();
        assertNotNull(jet);
        assertEquals(0, jet.getSpeed());
    }

    @Test
    void testStaticMethod() {
        Jet jet = new Jet();
        Airplane airplane = new Airplane();

        List<Airplane> airplanes = new ArrayList<>(Arrays.asList(
                jet,
                airplane
        ));

        for (Airplane a : airplanes) {
            a.myStaticMethod();
        }

        jet.myStaticMethod();
        airplane.myStaticMethod();

        Jet.myStaticMethod();
        Airplane.myStaticMethod();
    }
}
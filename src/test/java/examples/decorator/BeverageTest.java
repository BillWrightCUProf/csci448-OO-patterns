package examples.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {

    @Test
    void testEspresso() {
        Beverage espresso = new Espresso(Beverage.Size.VENTI);
        assertEquals("Espresso", espresso.getDescription());
        assertEquals(1.99, espresso.getCost());

        Beverage mochaEspresso = new Mocha(espresso);
        assertEquals("Espresso, Mocha", mochaEspresso.getDescription());
        assertEquals(2.19, mochaEspresso.getCost());

        Beverage whippedCreamMochaEspresso = new WhippedCream(mochaEspresso);
        assertEquals("Espresso, Mocha, Whipped Cream", whippedCreamMochaEspresso.getDescription());
        assertEquals(2.69, whippedCreamMochaEspresso.getCost());
    }

}
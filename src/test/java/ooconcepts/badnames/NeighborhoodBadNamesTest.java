package ooconcepts.badnames;

import org.junit.jupiter.api.Test;

class NeighborhoodBadNamesTest {

    @Test
    void testBadNames() {
        NeighborhoodBadNames n = new NeighborhoodBadNames(3, 4, 5);
        System.out.println("The neighborhood is " + n.w * n.l + " square blocks");
        System.out.println("and has a population of " + (n.w * n.l * n.d) + " people");
    }

    @Test
    void testGoodNames() {
        NeighborhoodGoodNames neighborhood = new NeighborhoodGoodNames(3, 4, 5);
        System.out.println("The neighborhood is " + neighborhood.getArea() + " square blocks");
        System.out.println("and has a population of " + neighborhood.getPopulation() + " people");
    }

}
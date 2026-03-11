package testquestions;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testMemoryOfVariables() {
        Player alice = new Player("Alice");
        Player bob = new Player("Bob");

        alice.addScore(10);
        bob.addScore(5);

        System.out.println(alice + ", " + bob + ", total instance count: " + Player.instanceCount);
    }

}
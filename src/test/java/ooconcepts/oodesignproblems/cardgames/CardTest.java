package ooconcepts.oodesignproblems.cardgames;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void testConstructor() {
        Card card = new Card(6, Suit.SPADES);
        assertEquals(6, card.value());
        assertEquals(Suit.SPADES, card.suit());
    }

}
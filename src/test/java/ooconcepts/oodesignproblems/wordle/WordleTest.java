package ooconcepts.oodesignproblems.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordleTest {
    static String INVALID_WORD = "zzzzz";
    static WordLibrary wordLibrary;

    @BeforeAll
    static void setup() throws Exception {
        wordLibrary = WordLibraryTest.getDefaultWordLibrary();
    }

    @Test
    void testLosingGame() {
        Wordle game = new Wordle(wordLibrary);
        while (!game.isGameOver()) {
            game.enterGuess(INVALID_WORD);
        }
        assertTrue(game.isGameOver());
        assertFalse(game.playerHasWon());

        System.out.println(game);
    }
}
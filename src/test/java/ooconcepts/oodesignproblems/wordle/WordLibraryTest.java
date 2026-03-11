package ooconcepts.oodesignproblems.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordLibraryTest {

    static WordLibrary wordLibrary;

    @BeforeAll
    static void setup() throws IOException {
        wordLibrary = getDefaultWordLibrary();         // Any setup if needed
    }

    @Test
    void testWordLibrary() throws IOException {
        String word = wordLibrary.getRandomTargetWord();
        System.out.println(word);
        assertNotNull(word);
        assertEquals(Wordle.WORD_LENGTH, word.length());
    }

    @Test
    void testValidGuessWord() throws IOException {
        assertTrue(wordLibrary.isValidGuessWord("aargh"));  // This cannot be a target word but is a valid guess word
        assertTrue(wordLibrary.isValidGuessWord("apple"));  // This is a valid target
        assertFalse(wordLibrary.isValidGuessWord("zzzzz")); // This is not a valid word
    }

    static WordLibrary getDefaultWordLibrary() throws IOException {
        return new WordLibrary("/wordle/targetWords.txt", "/wordle/guessWords.txt");
    }
}
package ooconcepts.oodesignproblems.wordle;

import java.util.ArrayList;
import java.util.List;

public class Wordle {
    static final int MAX_ATTEMPTS = 6;
    static final int WORD_LENGTH = 5;

    private WordLibrary wordLibrary;
    private List<Guess> guesses = new ArrayList<>();
    private String targetWord;

    public Wordle(WordLibrary wordLibrary) {
        this(wordLibrary, wordLibrary.getRandomTargetWord());
    }

    public Wordle(WordLibrary wordLibrary, String targetWord) {
        this.wordLibrary = wordLibrary;
        this.targetWord = targetWord;
    }

    public void enterGuess(String word) {
        guesses.add(new Guess(word));
    }

    public boolean isGameOver() {
        return guesses.size() >= MAX_ATTEMPTS || playerHasWon();
    }

    public boolean playerHasWon() {
        return !guesses.isEmpty() && guesses.getLast().matches(targetWord);
    }
}

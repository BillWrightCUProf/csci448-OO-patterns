package ooconcepts.oodesignproblems.wordle;

public class Guess {
    private String guessWord;

    public Guess(String word) {
        this.guessWord = word;
    }

    public boolean matches(String targetWord) {
        return this.guessWord.equals(targetWord);
    }
}

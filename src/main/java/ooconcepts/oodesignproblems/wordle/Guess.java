package ooconcepts.oodesignproblems.wordle;

// NOTE: I have another entire repo for this example, as I used it as a homework.
// Refer to that repo if you think something is missing here.

public class Guess {
    private String guessWord;

    public Guess(String word) {
        this.guessWord = word;
    }

    public boolean matches(String targetWord) {
        return this.guessWord.equals(targetWord);
    }
}

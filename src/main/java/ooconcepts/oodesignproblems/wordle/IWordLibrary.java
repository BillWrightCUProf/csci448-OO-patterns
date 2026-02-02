package ooconcepts.oodesignproblems.wordle;

public interface IWordLibrary {
    String getRandomTargetWord();
    boolean isValidGuessWord(String word);
}

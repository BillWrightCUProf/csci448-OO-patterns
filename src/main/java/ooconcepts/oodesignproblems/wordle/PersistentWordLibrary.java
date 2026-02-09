package ooconcepts.oodesignproblems.wordle;

import java.io.IOException;

public class PersistentWordLibrary extends WordLibrary {
    String filePathToUsedWords;

    PersistentWordLibrary(String targetWordsFilePath, String guessWordsFilePath) throws IOException {
        super(targetWordsFilePath, guessWordsFilePath);
        // Created remembered words using:
    }

    @Override
    public String getRandomTargetWord() {
        // Implementation to read from a file and return a random word
        return "apple"; // Placeholder
    }
}

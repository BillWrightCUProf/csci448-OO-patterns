package ooconcepts.oodesignproblems.wordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class WordLibrary implements IWordLibrary {
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");
    private static Random random = new Random();

    private List<String> availableTargetWords;
    private List<String> availableGuessWords;

    WordLibrary(String targetWordsFilePath, String guessWordsFilePath) throws IOException {
        this.availableTargetWords = readWords(targetWordsFilePath);
        this.availableGuessWords = readWords(guessWordsFilePath);
    }

    public String getRandomTargetWord() {
        return availableTargetWords.get(random.nextInt(availableTargetWords.size()));
    }

    @Override
    public boolean isValidGuessWord(String word) {
        return availableTargetWords.contains(word) || availableGuessWords.contains(word);
    }

    public static List<String> readWords(String filePath) throws IOException {
        // First look for the file in the resources directory
        try (var in = WordLibrary.class.getResourceAsStream(filePath); var reader = new BufferedReader(new InputStreamReader(in))) {
            return reader.lines().toList();
        } catch (Exception e) {
            // If not found in resources, try to read from the file system
            try (var lines = Files.lines(Path.of(filePath))) {
                return lines
                        .flatMap(WHITESPACE::splitAsStream)
                        .filter(s -> !s.isBlank())
                        .toList();
            }
        }
    }
}

package com.game.guesstheword.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.game.guesstheword.controllers.GameUtils;

@Service
@SessionScope
public class GameService {

    private static final String[] FRUITS = {
        "apple", "banana", "cherry", "date", "blueberry", "watermelon"
    };

    private static final String[] VEGETABLES = {
        "brinjal", "carrot", "beetroot", "potato", "spinach", "onion"
    };

    private static final String[] COLORS = {
        "gold", "lavender", "silver", "grey", "hotpink", "orange", "white"
    };

    private static final String[] ANIMALS = {
        "lion", "tiger", "elephant", "zebra", "monkey", "rabbit",
        "sheep", "deer", "dinosaur"
    };

    private static final String[] BIRDS = {
        "peacock", "kingfisher", "flamingo", "ostrich",
        "rooster", "penguin", "vulture"
    };

    private static final String[] FOOD = {
        "pizza", "burger", "sushi", "sandwich", "cake",
        "popcorn", "chips", "pasta", "waffles", "noodles", "nachos"
    };

    private final Random random = new Random();
    private final GameUtils gameUtils;

    private String randomlyChoosenWord;
    private char[] allCharsOfTheWord;
    private final Set<Character> guessedChars = new HashSet<>();
    private String category = "fruits";

    public GameService(GameUtils gameUtils) {
        this.gameUtils = gameUtils;
    }

    public void startNewGame(String requestedCategory) {
        String[] randomWords;

        if (requestedCategory == null) {
            requestedCategory = "fruits";
        }

        switch (requestedCategory) {
            case "vegetables":
                randomWords = VEGETABLES;
                break;
            case "birds":
                randomWords = BIRDS;
                break;
            case "food":
                randomWords = FOOD;
                break;
            case "animals":
                randomWords = ANIMALS;
                break;
            case "colors":
                randomWords = COLORS;
                break;
            case "fruits":
            default:
                requestedCategory = "fruits";
                randomWords = FRUITS;
                break;
        }

        category = requestedCategory;
        randomlyChoosenWord = randomWords[random.nextInt(randomWords.length)];
        allCharsOfTheWord = new char[randomlyChoosenWord.length()];
        guessedChars.clear();
        gameUtils.resetAttempts();
    }

    public String check(char ch) {
        if (!hasActiveGame()
                || isGameWon()
                || gameUtils.getRemainingAttempts() == 0) {
            return getRandomWord();
        }

        ch = Character.toLowerCase(ch);

        if (!Character.isLetter(ch) || !guessedChars.add(ch)) {
            return getRandomWord();
        }

        if (!randomlyChoosenWord.contains(String.valueOf(ch))) {
            gameUtils.decreaseRemainingAttempts();
            return getRandomWord();
        }

        for (int i = 0; i < randomlyChoosenWord.length(); i++) {
            if (randomlyChoosenWord.charAt(i) == ch) {
                allCharsOfTheWord[i] = ch;
            }
        }

        return getRandomWord();
    }

    public String getRandomWord() {
        if (!hasActiveGame()) {
            return "";
        }

        StringBuilder word = new StringBuilder();

        for (char c : allCharsOfTheWord) {
            if (c == '\u0000') {
                word.append("_ ");
            } else {
                word.append(c).append(" ");
            }
        }

        return word.toString();
    }

    public boolean isGameWon() {
        if (!hasActiveGame()) {
            return false;
        }

        for (char c : allCharsOfTheWord) {
            if (c == '\u0000') {
                return false;
            }
        }

        return true;
    }

    public boolean hasActiveGame() {
        return randomlyChoosenWord != null && allCharsOfTheWord != null;
    }

    public String getChosenWord() {
        return randomlyChoosenWord;
    }

    public String getCategory() {
        return category;
    }

    public String getGuessedChars() {
        if (guessedChars.isEmpty()) {
            return "None";
        }

        return guessedChars.stream()
                .sorted()
                .map(String::valueOf)
                .reduce((first, second) -> first + ", " + second)
                .orElse("None");
    }
}
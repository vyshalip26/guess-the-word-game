package com.game.guesstheword.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.game.guesstheword.controllers.GameUtils;
@Service
public class GameService {
    private String randomlyChoosenWord=null;
    private char[] allCharsOfTheWord;  
    private String[] fruits = {
        "apple", "banana", "cherry", "date", "blueberry","watermelon"
    }; 
    private String[] vegetables={
        "brinjal", "carrot", "beetroot", "potato", "spinach","onion"
    };
    private String[] colors={
        "gold", "lavender", "silver", "grey", "hotpink","orange","white"
    };
    private String[] animals = {
        "lion", "tiger", "elephant", "zebra", "monkey", "rabbit","sheep","deer","dinosaur"
    };
    private String[] birds={
        "peacock","kingfisher","flamingo","ostrich","rooster","penguin","vulture"
    };
    private String[] food={
        "pizza","burger","sushi","sandwich","cake","popcorn","chips","pasta","waffles","noodles","nachos"
    };
    private String randomWords[];
    
    private Random random = new Random();
    private final GameUtils gameUtils;

    public GameService(GameUtils gameUtils) {
        this.gameUtils = gameUtils;
    }
    public void startNewGame(String category) {
        switch(category)
        {
            case "fruits":
                randomWords=fruits;
                break;
            case "vegetables":
                randomWords=vegetables;
                break;
            case "birds":
                randomWords=birds;
                break;
            case "food":
                randomWords=food;
                break;
            case "animals":
                randomWords=animals;
                break;
            case "colors":
                randomWords=colors;
                break;
            default:
                randomWords=fruits;
        }
        randomlyChoosenWord = randomWords[random.nextInt(randomWords.length)];
        System.out.println("Randomly chosen word: " + randomlyChoosenWord); // Log the randomly chosen word
        allCharsOfTheWord = new char[randomlyChoosenWord.length()];
    }
    public String getRandomWord() {
        String word="";
        for(char c:allCharsOfTheWord){
            if(c=='\u0000'){
                word+="_ ";
            }else{
                word+=c+" ";
            }
            
        }
        return word;
    }
    public boolean isGameWon() {
        for (char c : allCharsOfTheWord) {
            if (c == '\u0000') {
                return false;
            }
        }
        return true;
    }
    public String check(char ch)
    { 
        if(!randomlyChoosenWord.contains(String.valueOf(ch))){
            gameUtils.decreaseRemainingAttempts();
        }
        String word="";
        for(int i=0;i<randomlyChoosenWord.length();i++){
            if(randomlyChoosenWord.charAt(i)==ch){
                allCharsOfTheWord[i]=ch; 
            }
            if(allCharsOfTheWord[i]=='\u0000'){
                word+="_ ";
            }else{
                word+=allCharsOfTheWord[i]+" ";
            }
        }
        return word;
    }
    public String getChosenWord() {
        return randomlyChoosenWord;
    }

}
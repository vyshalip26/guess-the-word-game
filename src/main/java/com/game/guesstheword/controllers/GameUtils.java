package com.game.guesstheword.controllers;

import org.springframework.stereotype.Component;

@Component
public class GameUtils {

    private int remainingAttempts = 5;
 
    public int getRemainingAttempts() {
        return remainingAttempts;
    }
 
    public void decreaseRemainingAttempts() {
        if (remainingAttempts > 0) {
            remainingAttempts--;
        }
    }

    public void resetAttempts() {
        remainingAttempts = 5;
    }
}
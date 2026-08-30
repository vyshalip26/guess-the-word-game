package com.game.guesstheword.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.game.guesstheword.service.GameService;

@Controller
public class GameController {

    private final GameService gameService;
    private final GameUtils gameUtils;

    public GameController(GameService gameService, GameUtils gameUtils) {
        this.gameService = gameService;
        this.gameUtils = gameUtils;
    }

    @GetMapping("/")
    public String home() {
        return "home-page";
    }

    @GetMapping("/game")
    public String showGamePage(
            @RequestParam(value = "guessedChar", required = false) String guessedCh,
            @RequestParam(value = "category", required = false) String category,
            Model model) {

        if (guessedCh == null || guessedCh.isBlank()) {
            gameService.startNewGame(category);
        } else {
            if (!gameService.hasActiveGame()) {
                gameService.startNewGame(category);
            }

            String guess = guessedCh.trim();

            if (guess.length() == 1) {
                gameService.check(guess.charAt(0));
            }
        }

        boolean gameWon = gameService.isGameWon();
        boolean gameOver = gameUtils.getRemainingAttempts() == 0 && !gameWon;

        model.addAttribute("updatedWord", gameService.getRandomWord());
        model.addAttribute("remainingAttempts", gameUtils.getRemainingAttempts());
        model.addAttribute("category", gameService.getCategory());
        model.addAttribute("gameOver", gameOver);
        model.addAttribute("gameWon", gameWon);
        model.addAttribute("chosenWord", gameService.getChosenWord());
        model.addAttribute("guessedChars", gameService.getGuessedChars());

        if (gameOver) {
            model.addAttribute("correctWord", gameService.getChosenWord());
        }

        return "game-home-page";
    }
}
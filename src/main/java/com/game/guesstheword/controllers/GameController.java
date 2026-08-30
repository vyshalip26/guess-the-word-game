package com.game.guesstheword.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.game.guesstheword.service.GameService;

@Controller
public class GameController {

    private final GameService gameService;
    private final GameUtils gameUtils;

    @Autowired
    public GameController(GameService gameService, GameUtils gameUtils) {
        this.gameService = gameService;
        this.gameUtils = gameUtils;
    }

    private String game_category;

    @GetMapping("/")
    public String home() {
        return "home-page";
    }

    @GetMapping("/game")
    public String showGamePage(
            @RequestParam(value = "guessedChar", required = false) String guessedCh,
            @RequestParam(value = "category", required = false) String category,
            Model model) {

        String updatedWord;
        boolean gameOver=false; 
        boolean gameWon=false;
        
        if (category != null) {
            game_category = category;
        }
 
        if (guessedCh == null || guessedCh.isEmpty()) {
            gameUtils.resetAttempts();
            gameService.startNewGame(game_category);
            updatedWord = gameService.getRandomWord(); 
        }
         
        else {
            char guessedCharacter = Character.toLowerCase(guessedCh.charAt(0));

            updatedWord = gameService.check(guessedCharacter);
            gameWon=gameService.isGameWon();
            if(gameUtils.getRemainingAttempts()==0 && !gameWon)
            {
                gameOver=true;
            }
        }

        model.addAttribute("updatedWord", updatedWord);

        model.addAttribute(
                "remainingAttempts",
                gameUtils.getRemainingAttempts()
        );

        model.addAttribute("category", game_category);
        model.addAttribute("gameOver",gameOver);
        System.out.println("Guessed character: " + guessedCh);
        model.addAttribute("gameWon", gameWon);
        model.addAttribute("chosenWord", gameService.getChosenWord());  
       
        if (gameOver) { 
            model.addAttribute("correctWord",
                    gameService.getChosenWord());
        }  
        return "game-home-page";
    }
}

# Guess the Word Game

Guess the Word is a simple web-based word guessing game built using Spring Boot and Thymeleaf.

The game starts with a category selection page. After selecting a category, a random word is chosen and displayed as hidden letters. The player has to guess the word one character at a time within a limited number of attempts.

<img width="1920" height="1080" alt="Video Project 5" src="https://github.com/user-attachments/assets/185bc9ff-cd4d-49c9-9d0a-2eed4b5a4db0" />

## Features

- Choose from different word categories
- Categories currently include Fruits, Vegetables, Colors, Food, Animals, and Birds
- A random word is selected from the chosen category
- The word is initially displayed using blanks
- Correctly guessed characters are revealed in their respective positions
- Incorrect guesses reduce the number of remaining attempts
- The game shows a dialog when the player wins
- The game also shows the correct word when all attempts are used
- Restart the game with a new word from the same category
- Return to the category selection page

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- HTML
- CSS
- Maven

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.game.guesstheword
    │       ├── controllers
    │       │   ├── GameController.java
    │       │   └── GameUtils.java
    │       └── service
    │           └── GameService.java
    │
    └── resources
        ├── templates
        │   ├── home-page.html
        │   └── game-home-page.html
        └── application.properties

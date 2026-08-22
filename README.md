# Guess the Word Game

Guess the Word is a simple web-based word guessing game built using Spring Boot and Thymeleaf.

The game starts with a category selection page. After selecting a category, a random word is chosen and displayed as hidden letters. The player has to guess the word one character at a time within a limited number of attempts.
<img width="1803" height="828" alt="image" src="https://github.com/user-attachments/assets/a9c4b013-02ea-4047-b4fa-2b5d4441d771" />


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

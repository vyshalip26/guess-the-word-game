# Guess the Word Game

Guess the Word is a simple web-based word guessing game built using Spring Boot and Thymeleaf.

The game starts with a category selection page. After the user selects a category, a random word related to that category is chosen and displayed as hidden letters. The player has to guess the word one character at a time within 5 attempts.
If the user failed to guess the word, Game-Over dialog box reveals the hidden word. Otherwise the user gets a success message (Game-Win dialog box).

Here is a small clip showcasing the live site
<img width="1920" height="1080" alt="Video Project 5" src="https://github.com/user-attachments/assets/185bc9ff-cd4d-49c9-9d0a-2eed4b5a4db0" />


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
```

## How to try
- LIVE DEMO : https://vyshu.hackclub.app/
- Running it locally:
  1. Clone the Repository.
  ```
  git clone https://github.com/vyshalip26/guess-the-word-game.git
  ```

  2. 
     Run the application using maven.
  ```
  mvn spring-boot:run
  ```
  3. Open the application.
     
  http://localhost:8080

## Author
Vyshali

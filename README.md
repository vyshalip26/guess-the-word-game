# Guess the Word Game

Guess the Word is a simple web-based word guessing game built using Spring Boot and Thymeleaf.

The game starts with a category selection page. After the user selects a category, a random word related to that category is chosen and displayed as hidden letters. The player has to guess the word one character at a time within 5 attempts.
If the user failed to guess the word, Game-Over dialog box reveals the hidden word. Otherwise Game-Win dialog box displays.
 

Here is a small clip showcasing the live site



https://github.com/user-attachments/assets/17bbed30-673c-411b-aba6-73b52de41da0

 

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
- LIVE DEMO :
  This website is deployed on **Hack Club Nest** and is publicly accessible at https://vyshu.hackclub.app/ .
- Running it locally:
  1. Clone the Repository.
  ```
  git clone https://github.com/vyshalip26/guess-the-word-game.git
  ```

  2. Change to the projects directory.
  ```
  cd guess-the-word-game
  ```
  3. Run the application using maven.
  ```
  mvn spring-boot:run
  ```
  4. Open the application.
     
  http://localhost:8080

## Author
Vyshali❤️

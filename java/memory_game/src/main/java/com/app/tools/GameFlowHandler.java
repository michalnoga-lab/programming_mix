package com.app.tools;

import com.app.model.Words;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class GameFlowHandler {

    public void displayGameFlow(Integer allChances, String coordinatesRegex, Words gameWords, DisplayHandler displayHandler, Integer boardSize, String level) {
        Integer chancesLeft = allChances;
        Instant gameStart = Instant.now();

        System.out.println("Chosen level: " + level);
        System.out.println("Chances left: " + allChances);

        displayHandler.displayGameBoard(gameWords, boardSize);

        while (chancesLeft > 0) {
            String userCoordinate1 = "";
            String userCoordinate2 = "";

            while (!userCoordinate1.matches(coordinatesRegex)) {
                System.out.println("Enter coordinates (in format: digit number, no spaces) for first word to reveal: ");
                userCoordinate1 = InnerTools.getScanner().nextLine();
            }
            gameWords.showOneWordTemporary(userCoordinate1);
            displayHandler.displayGameBoard(gameWords, boardSize);

            while (!userCoordinate2.matches(coordinatesRegex)) {
                System.out.println("Enter coordinates (in format: digit number, no spaces) for second word to reveal: ");
                userCoordinate2 = InnerTools.getScanner().nextLine();
            }
            gameWords.showOneWordTemporary(userCoordinate2);
            displayHandler.displayGameBoard(gameWords, boardSize);

            if (gameWords.areWordsTheSame(userCoordinate1, userCoordinate2)) {
                System.out.println("Correct guess. Chances left: " + chancesLeft);
                if (gameWords.getAllWordsGuessed()) {
                    System.out.println("*****************************************************************************************************");
                    System.out.println("You WON! You guessed all words!");
                    Instant gameEnd = Instant.now();
                    Duration gameDuration = Duration.between(gameStart, gameEnd);
                    System.out.println("You used " + (allChances - chancesLeft) + " chances during the game. It took You " + (gameDuration.toMillis() / 1000) + " seconds");
                    System.out.println("*****************************************************************************************************");
                    gameWords.clearWordsTable();
                    System.out.print("Enter Your name for High Score Board: ");
                    String userName = InnerTools.getScanner().nextLine();
                    FileHandler fileHandler = new FileHandler();
                    fileHandler.saveUserScoreToFile(userName, LocalDateTime.now(), gameDuration, allChances - chancesLeft);
                    break;
                }
                displayHandler.waitForKeyPress();
            } else {
                System.out.println("Incorrect guess. Chances left: " + (chancesLeft -= 1));
                displayHandler.waitForKeyPress();
                gameWords.hideAllTemporary();
                displayHandler.displayGameBoard(gameWords, boardSize);
            }
        }

        if (chancesLeft == 0) {
            System.out.println("*****************************************************************************************************");
            System.out.println("You have lost. No chances left.");
            System.out.println("*****************************************************************************************************");
            gameWords.clearWordsTable();
        }
    }
}

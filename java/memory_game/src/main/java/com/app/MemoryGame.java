package com.app;

import com.app.model.Player;
import com.app.model.Scores;
import com.app.model.Words;
import com.app.service.WordsService;
import com.app.service.WordsServiceImpl;
import com.app.tools.DisplayHandler;
import com.app.tools.FileHandler;
import com.app.tools.GameFlowHandler;
import com.app.tools.InnerTools;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * <h1>MEMORY GAME</h1>
 * <p>
 * Simple memory game where user has to guess words.
 * On simple level there are four words to guess, and ten chances to use.
 * On hard level there are eight words to guess, and fifteen chances to use.
 * </p>
 *
 * @author Michał Noga
 * @version 1.0
 */

@SpringBootApplication
public class MemoryGame {
    private static String userChoice = "";
    private static final Integer boardSize = 4;
    private static final Integer chancesForEasyLevel = 10;
    private static final Integer chancesForHardLevel = 15;
    private static final DisplayHandler displayHandler = new DisplayHandler();
    private static final WordsService wordsService = new WordsServiceImpl();
    private static final Words gameWords = new Words();
    private static final GameFlowHandler gameFlowHandler = new GameFlowHandler();

    private static final Scores highScores = new Scores();

    private static final FileHandler fileHandler = new FileHandler();

    public static void main(String[] args) {

        while (!userChoice.equals("end")) {
            displayHandler.displayDifficultyLevelMenu();
            userChoice = InnerTools.getScanner().nextLine();

            if (userChoice.equals("1")) {
                List<String> words = wordsService.getWords(4);
                List<String> doubledWords = wordsService.doubleAndShuffleWords(words);

                gameWords.saveInitialWords(doubledWords, boardSize);
                gameFlowHandler.displayGameFlow(chancesForEasyLevel, "^\\d[A-B]{1}", gameWords, displayHandler, boardSize, "EASY");

            } else if (userChoice.equals("2")) {
                List<String> words = wordsService.getWords(8);
                List<String> doubledWords = wordsService.doubleAndShuffleWords(words);

                gameWords.saveInitialWords(doubledWords, boardSize);
                gameFlowHandler.displayGameFlow(chancesForHardLevel, "^\\d[A-D]{1}", gameWords, displayHandler, boardSize, "HARD");

            } else if (userChoice.equals("end")) {
                break;
            } else {
                System.out.println("You entered wrong level");
                System.out.println("Try again");
                continue;
            }

            System.out.println("Do You want to play again?");
            System.out.println("Type Y for yes or N for no");
            userChoice = InnerTools.getScanner().nextLine();

            if (userChoice.equalsIgnoreCase("Y") || userChoice.equalsIgnoreCase("YES")) {
                gameWords.clearWordsTable();
            } else if (userChoice.equalsIgnoreCase("N") || userChoice.equalsIgnoreCase("NO")) {
                break;
            }
        }

        List<Player> players = fileHandler.getScoresFileContent();
        highScores.addManyPlayersToHighScores(players);
        displayHandler.displayHighScores(highScores);

        System.out.println("Game has ended");

        InnerTools.closeScanner();
    }
}
package com.app.tools;

import com.app.model.Scores;
import com.app.model.Words;

import java.util.concurrent.atomic.AtomicReference;

public class DisplayHandler {

    private static final Integer WORD_WRAPPER_LENGTH = 15;

    public void displayDifficultyLevelMenu() {
        displayMenuSeparator();
        System.out.println("Choose difficulty level (enter 1 or 2):");
        System.out.println("1 - easy");
        System.out.println("2 - hard");
        displayMenuSeparator();
        System.out.println("I choose: ");
    }

    public void displayGameBoard(Words words, Integer boardSize) {
        int legendLetterIndex = 0;

        displayVerticalLegend(-20);
        displayHorizontalLegend(boardSize);
        displayBottomSeparator(boardSize);

        for (int i = 0; i < words.getWords().size(); i++) {

            if (i == 0) {
                displayVerticalLegend(legendLetterIndex);
                legendLetterIndex += 1;
            }
            if (i > 0 && i % boardSize == 0) {
                System.out.println("|");
                displayVerticalLegend(legendLetterIndex);
                legendLetterIndex += 1;
            }

            System.out.print(wrapWord(words.getWords().get(i).isGuessed() || words.getWords().get(i).isVisible() ?
                    String.valueOf(words.getWords().get(i).getWord()) : "X"));
        }

        System.out.println("|");
        displayBottomSeparator(boardSize);

    }

    private void displayMenuSeparator() {
        System.out.println("-------------------------------------------------------------------");
    }

    private void displayBottomSeparator(Integer boardSize) {
        System.out.println("_".repeat(Math.max(0, (WORD_WRAPPER_LENGTH + 1) * boardSize) + 1));
    }

    private void displayHorizontalLegend(Integer size) {
        for (int i = 0; i < size; i++) {
            Integer value = i + 1;
            System.out.print(wrapWord(String.valueOf(value)));
        }
        System.out.println("|");
    }

    private void displayVerticalLegend(Integer start) {
        System.out.print((char) (start + 65));
        System.out.print("  ");
    }

    private String wrapWord(String word) {

        return "|" + word + " ".repeat(Math.max(0, WORD_WRAPPER_LENGTH - word.length()));
    }

    public void waitForKeyPress() {
        System.out.println("Press ENTER to continue ...");
        InnerTools.getScanner().nextLine();
    }

    public void displayHighScores(Scores highScores) {
        displayMenuSeparator();
        AtomicReference<Integer> number = new AtomicReference<>(0);
        System.out.println("Best of all time: (name, time played, game duration, used chances)");

        highScores
                .getPlayersScores()
                .forEach(score -> {
                    System.out.print(
                            number.updateAndGet(v -> v + 1) + " " +
                                    wrapWord(score.getName()) + " " +
                                    wrapWord(score.getTime().toString().replace("T", " ").substring(0, 19)) + " " +
                                    wrapWord(score.getGameDuration().toMillis() / 1000 + " seconds") + " " +
                                    wrapWord(score.getGuessesUsed() + " chances used")
                    );
                    System.out.println("");
                });
        displayMenuSeparator();
    }
}
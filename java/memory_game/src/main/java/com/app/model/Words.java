package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Words {
    private List<SingleWord> words = new ArrayList<>();
    private Integer guessedWordsCounter = 0;
    private Boolean allWordsGuessed = false;

    public void saveInitialWords(List<String> inputWords, Integer boardSize) {
        int horizontalLegendIndex = 0;
        int verticalLegendIndex = 65;

        for (String inputWord : inputWords) {
            if (horizontalLegendIndex >= boardSize) {
                horizontalLegendIndex = 0;
                verticalLegendIndex += 1;
            }
            horizontalLegendIndex += 1;

            words.add(SingleWord
                    .builder()
                    .word(inputWord)
                    .guessed(false)
                    .visible(false)
                    .firstCoordinate(String.valueOf(horizontalLegendIndex))
                    .secondCoordinate(String.valueOf((char) verticalLegendIndex))
                    .build());
        }
    }

    public void showOneWordTemporary(String coordinates) {
        getWords()
                .stream()
                .filter(element -> element.getFirstCoordinate().equals(String.valueOf(coordinates.charAt(0))))
                .filter(element -> element.getSecondCoordinate().equals(String.valueOf(coordinates.charAt(1))))
                .forEach(element -> element.setVisible(true));
    }

    public boolean areWordsTheSame(String coordinate1, String coordinate2) {
        SingleWord singleWord1 =
                getWords()
                        .stream()
                        .filter(element -> element.getFirstCoordinate().equals(String.valueOf(coordinate1.charAt(0))))
                        .filter(element -> element.getSecondCoordinate().equals(String.valueOf(coordinate1.charAt(1))))
                        .toList()
                        .get(0);
        SingleWord singleWord2 =
                getWords()
                        .stream()
                        .filter(element -> element.getFirstCoordinate().equals(String.valueOf(coordinate2.charAt(0))))
                        .filter(element -> element.getSecondCoordinate().equals(String.valueOf(coordinate2.charAt(1))))
                        .toList()
                        .get(0);

        boolean theSame = singleWord1.getWord().equals(singleWord2.getWord());

        if (theSame) {
            guessedWordsCounter += 2;

            if (guessedWordsCounter == getWords().size()) {
                allWordsGuessed = true;
            }

            singleWord1.setGuessed(true);
            singleWord2.setGuessed(true);
        }

        return theSame;
    }

    public void hideAllTemporary() {
        getWords()
                .forEach(element -> element.setVisible(false));
    }

    public void clearWordsTable() {
        setWords(new ArrayList<>());
        allWordsGuessed = false;
        guessedWordsCounter = 0;
    }
}

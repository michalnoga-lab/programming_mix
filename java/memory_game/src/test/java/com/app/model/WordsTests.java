package com.app.model;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class WordsTests {


    @Test
    @Description("Check if initial words are saved - empty words list")
    void saveInitialWords1() {
        List<String> initialWords = List.of();

        Words expectedWords = new Words();
        expectedWords.setWords(List.of());
        expectedWords.setGuessedWordsCounter(0);
        expectedWords.setAllWordsGuessed(false);

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if initial words are saved - one word")
    void saveInitialWords2() {
        List<String> initialWords = List.of("aa");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(SingleWord
                .builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build()));
        expectedWords.setGuessedWordsCounter(0);
        expectedWords.setAllWordsGuessed(false);

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if initial words are saved - multiple words saved in one line")
    void saveInitialWords3() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build()
        ));
        expectedWords.setGuessedWordsCounter(0);
        expectedWords.setAllWordsGuessed(false);

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if initial words are saved - multiple words saved in two lines")
    void saveInitialWords4() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));
        expectedWords.setGuessedWordsCounter(0);
        expectedWords.setAllWordsGuessed(false);

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if only one word is revealed - coordinate 1A")
    void showOneWordTemporary1() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(true).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        actualWords.showOneWordTemporary("1A");
        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if only one word is revealed - coordinate 4A")
    void showOneWordTemporary2() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(true).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        actualWords.showOneWordTemporary("4A");
        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if only one word is revealed - coordinate 1B")
    void showOneWordTemporary3() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(true).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        actualWords.showOneWordTemporary("1B");
        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if only one word is revealed - coordinate 4B")
    void showOneWordTemporary4() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(true).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        actualWords.showOneWordTemporary("4B");
        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if words are the same")
    void areWordsTheSame1() {
        List<String> initialWords = List.of("dd", "bb", "aa", "bb", "cc", "cc", "dd", "aa");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);

        boolean result1 = actualWords.areWordsTheSame("1A", "3B");
        boolean result2 = actualWords.areWordsTheSame("1A", "2A");
        boolean result3 = actualWords.areWordsTheSame("1A", "3A");
        boolean result4 = actualWords.areWordsTheSame("1A", "4A");
        boolean result5 = actualWords.areWordsTheSame("2A", "3A");
        boolean result6 = actualWords.areWordsTheSame("3A", "4B");

        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
        Assertions.assertFalse(result3);
        Assertions.assertFalse(result4);
        Assertions.assertFalse(result5);
        Assertions.assertTrue(result6);
    }

    @Test
    @Description("Check if temporary revealed words will be hidden - two words")
    void hideAllTemporary1() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);
        actualWords.showOneWordTemporary("1A");
        actualWords.showOneWordTemporary("3B");
        actualWords.hideAllTemporary();

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if temporary revealed words will be hidden - all words")
    void hideAllTemporary2() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of(
                SingleWord.builder().word("aa").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("A").build(),
                SingleWord.builder().word("bb").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("A").build(),
                SingleWord.builder().word("cc").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("A").build(),
                SingleWord.builder().word("dd").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("A").build(),
                SingleWord.builder().word("ee").guessed(false).visible(false).firstCoordinate("1").secondCoordinate("B").build(),
                SingleWord.builder().word("ff").guessed(false).visible(false).firstCoordinate("2").secondCoordinate("B").build(),
                SingleWord.builder().word("gg").guessed(false).visible(false).firstCoordinate("3").secondCoordinate("B").build(),
                SingleWord.builder().word("hh").guessed(false).visible(false).firstCoordinate("4").secondCoordinate("B").build()
        ));

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);
        actualWords.showOneWordTemporary("1A");
        actualWords.showOneWordTemporary("2A");
        actualWords.showOneWordTemporary("3A");
        actualWords.showOneWordTemporary("4A");
        actualWords.showOneWordTemporary("1B");
        actualWords.showOneWordTemporary("2B");
        actualWords.showOneWordTemporary("3B");
        actualWords.showOneWordTemporary("4B");
        actualWords.hideAllTemporary();

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if words table will be cleared")
    void clearWordsTable1() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of());

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);
        actualWords.clearWordsTable();

        Assertions.assertEquals(expectedWords, actualWords);
    }

    @Test
    @Description("Check if words guessed counter will be zeroed")
    void clearWordsTable2() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of());
        expectedWords.setGuessedWordsCounter(0);

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);
        actualWords.setGuessedWordsCounter(10);
        actualWords.clearWordsTable();

        Assertions.assertEquals(expectedWords, actualWords);
        Assertions.assertEquals(0, actualWords.getGuessedWordsCounter());
    }

    @Test
    @Description("Check if global words guessed status will be false")
    void clearWordsTable3() {
        List<String> initialWords = List.of("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        Words expectedWords = new Words();
        expectedWords.setWords(List.of());
        expectedWords.setAllWordsGuessed(false);

        Words actualWords = new Words();
        actualWords.saveInitialWords(initialWords, 4);
        actualWords.setAllWordsGuessed(true);
        actualWords.clearWordsTable();

        Assertions.assertEquals(expectedWords, actualWords);
        Assertions.assertFalse(actualWords.getAllWordsGuessed());
    }
}

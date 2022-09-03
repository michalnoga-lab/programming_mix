package com.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
public class WordServiceImplTests {

    @Test
    @Description("Check if all words are unique - only unique words")
    void areAllWordsUnique1() {
        WordsService wordsService = new WordsServiceImpl();
        Assertions.assertTrue(wordsService.areAllWordsUnique(List.of("aa", "bb")));
    }

    @Test
    @Description("Check if all words are unique - non unique words")
    void areAllWordsUnique2() {
        WordsService wordsService = new WordsServiceImpl();
        Assertions.assertFalse(wordsService.areAllWordsUnique(List.of("aa", "aa")));
    }

    @Test
    @Description("Check if words are doubled")
    void doubleAndShuffleWords1() {
        WordsService wordsService = new WordsServiceImpl();
        List<String> inputWords = List.of("aa", "bb", "cc", "dd");
        List<String> doubledWords = wordsService.doubleAndShuffleWords(inputWords);

        Assertions.assertEquals(4, inputWords.size());
        Assertions.assertEquals(8, doubledWords.size());
    }

    @Test
    @Description("Check if words are shuffled")
    void doubleAndShuffleWords2() {
        WordsService wordsService = new WordsServiceImpl();
        List<String> inputWords = List.of("aa", "bb", "cc", "dd");
        List<String> doubledWords = wordsService.doubleAndShuffleWords(inputWords);

        Assertions.assertNotEquals(inputWords, doubledWords);
    }
}

package com.app.service;

import java.util.List;

public interface WordsService {

    List<String> getWords(int howMany);

    List<String> doubleAndShuffleWords(List<String> words);

    boolean areAllWordsUnique(List<String> wordsToCheck);
}

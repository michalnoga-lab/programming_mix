package com.app.service;

import com.app.tools.FileHandler;

import java.util.*;
import java.util.stream.Collectors;

public class WordsServiceImpl implements WordsService {

    @Override
    public List<String> getWords(int howMany) {
        List<String> words = new FileHandler().getWordsFileContent();
        List<String> randomWords = Arrays.stream(new Random().ints(howMany, 0, words.size()).toArray()).mapToObj(words::get).collect(Collectors.toList());

        while (!areAllWordsUnique(randomWords)) {
            randomWords = Arrays.stream(new Random().ints(howMany, 0, words.size()).toArray()).mapToObj(words::get).collect(Collectors.toList());
        }
        return randomWords;
    }

    @Override
    public List<String> doubleAndShuffleWords(List<String> words) {
        List<String> inputWords = new ArrayList<>(words);
        List<String> doubledWords = new ArrayList<>(words);

        Random random = new Random();

        while (inputWords.size() > 0) {
            String element = inputWords.get(random.nextInt(inputWords.size()));
            doubledWords.add(element);
            inputWords.remove(element);
        }

        return doubledWords;
    }

    @Override
    public boolean areAllWordsUnique(List<String> wordsToCheck) {
        return new HashSet<>(wordsToCheck).size() == wordsToCheck.size();
    }
}

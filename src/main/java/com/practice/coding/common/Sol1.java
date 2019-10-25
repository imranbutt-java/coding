package com.practice.coding.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sol1 {

    static List<String> functionWord(String literatureText, List<String> wordsToExclude) {
        if(literatureText == null) {
            return new ArrayList<>();
        }
        Map<String, Integer> countOfWords = new HashMap<>();
        String[] splitted = literatureText.split(" ");
        for(String word : splitted) {
            if(wordsToExclude != null && wordsToExclude.contains(word)) {
                continue;
            }
            Integer count = countOfWords.get(word);
            if(count == null) {
                count = 1;
            } else {
                count++;
            }
            countOfWords.put(word, count);
        }
        return countOfWords.entrySet().stream().map(entry -> entry.getKey()).collect(Collectors.toList());
    }
}

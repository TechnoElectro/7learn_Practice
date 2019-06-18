package com.example.myapplication.utils;

import com.example.myapplication.model.WordCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextHelper {

    public static Character getCharAtPosition(String text) {
        return text.charAt(9);
    }

    public static char[] getMultipleOf(String text){
       int charCount = text.length()/10; // max size of array
        char[] chars = new char[charCount];
        int j = 0;
        for (int i = 9; i < text.length(); i = i + 10) {
            chars[j++]=text.charAt(i);
        }
        return chars;
    }

    public static List<WordCount> getWordCount(String text) {
        //Converts the string into lowercase
        String string = text.toLowerCase();
        List<WordCount> wordCountList = new ArrayList<>();
        //Split the string into words using built-in function
        String[] words = string.split(" ");
        for (String word : words) {
            int frequency = Collections.frequency(Arrays.asList(words), word);
              WordCount wordCount = new WordCount(word,frequency);
              wordCountList.add(wordCount);
        }
        return wordCountList;
    }

}

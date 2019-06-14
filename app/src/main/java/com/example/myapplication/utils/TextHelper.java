package com.example.myapplication.utils;

import com.example.myapplication.model.WordCount;

import java.util.ArrayList;
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
        int repeatedWords;

        //Converts the string into lowercase
        String string = text.toLowerCase();
        List<WordCount> wordCountList = new ArrayList<>();
        //Split the string into words using built-in function
        String[] words = string.split(" ");

        for (int i = 0; i < words.length; i++) {
            repeatedWords = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    repeatedWords++;
                    //Set words[j] to 0 to avoid printing visited word
                    words[j] = "0";
                }
            }
            //Displays the duplicate word
            if (repeatedWords >= 1 && words[i] != "0") {
                WordCount wordCount = new WordCount(words[i],repeatedWords);
                wordCountList.add(wordCount);
            }
        }

        return wordCountList;
    }

}

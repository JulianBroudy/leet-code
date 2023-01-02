package io.broudy.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * 
 * https://leetcode.com/problems/word-pattern/description/
 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";

        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {

        String[] words = s.split("\\s+");
        if (words.length != pattern.length()) {
            return false;
        }

        final Map<Character, String> map = new HashMap<>();
        String word;
        char ch;
        for (int i = 0; i < words.length; i++) {
            ch = pattern.charAt(i);
            word = words[i];

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if(map.containsValue(word)){
                    return false;
                }
                map.put(ch, word);
            }
        }
        return true;
    }
}

package io.broudy.leetcode.solutions;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        StringBuilder current = new StringBuilder("");
        String longestString = "";

        char ch;
        final int length = s.length();
        for (int i = 0; i < length; i++) {

            if (current.toString().contains(String.valueOf((ch = s.charAt(i))))) {
                current = new StringBuilder(current.substring(current.toString().indexOf(ch) + 1));
            }

            current.append(ch);

            if (longestString.length() < current.length()) {
                longestString = current.toString();
            }
        }
        return longestString.length();
    }

}

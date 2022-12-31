package io.broudy.leetcode.solutions;

/**
 * 383. Ransom Note
 *
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    public static void main(String[] args) {
        final String magazine = "ab";
        final String ransomNote = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        final boolean canConstruct = true;

        int[] magazineOccurrences = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            magazineOccurrences[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (magazineOccurrences[ransomNote.charAt(i) - 'a'] > 0) {
                magazineOccurrences[ransomNote.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }

        return canConstruct;
    }

}

package io.broudy.leetcode.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/candy">135. Candy</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class Candy {
    public static void main(String[] args) {
//        int[] ratings = new int[]{1, 0, 2}; // Expected: 5
//        int[] ratings = new int[]{1, 2, 2}; // Expected: 4
        // Edge test cases
// Edge test cases
//        int[] ratings = new int[]{1, 2, 3, 4, 5}; // Expected: 15
//        int[] ratings = new int[]{5, 4, 3, 2, 1}; // Expected: 15
// int[] ratings = new int[]{1, 1, 1, 1, 1}; // Expected: 5
// int[] ratings = new int[]{1, 2, 1, 2, 1}; // Expected: 7
// int[] ratings = new int[]{1, 3, 2, 2, 1}; // Expected: 7
// int[] ratings = new int[]{1, 2, 87, 87, 87, 2, 1}; // Expected: 13
        int[] ratings = new int[]{1, 6, 10, 8, 7, 3, 2}; // Expected: 16
        System.out.println(candy(ratings));
    }

    private static int candy(int[] ratings) {
        final int[] candiesPerChild = new int[ratings.length];
        candiesPerChild[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candiesPerChild[i] = ratings[i] > ratings[i - 1] ? candiesPerChild[i - 1] + 1 : 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && !(candiesPerChild[i] > candiesPerChild[i + 1])) {
                candiesPerChild[i] = candiesPerChild[i + 1] + 1;
            }
        }
        return Arrays.stream(candiesPerChild).sum();
    }
}
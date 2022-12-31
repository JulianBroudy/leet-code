package io.broudy.leetcode.solutions;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 384. Shuffle an Array
 *
 * https://leetcode.com/problems/shuffle-an-array/description/
 */
public class ShuffleAnArray {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    static class Solution {

        private final Random random;
        private final int[] originalNums;
        private final int[] cloned;
        private final int originalLength;
        private int replaceThisIndex;

        public Solution(int[] nums) {
            this.random = new Random();
            this.originalNums = nums;
            this.cloned = nums.clone();
            this.originalLength = nums.length;
            this.replaceThisIndex = 1;
        }

        public int[] reset() {
            return this.originalNums;
        }

        public int[] shuffle() {
            final int withThisIndex = random.nextInt(this.originalLength);

            final int temp = this.cloned[this.replaceThisIndex];
            this.cloned[this.replaceThisIndex] = this.cloned[withThisIndex];
            this.cloned[withThisIndex] = temp;

            if (this.replaceThisIndex < this.originalLength - 1) {
                this.replaceThisIndex++;
            } else {
                this.replaceThisIndex = 0;
            }

            return this.cloned;
        }
    }

    static class Solution2 {

        private final int[] originalNums;
        private final int originalLength;

        public Solution2(int[] nums) {
            this.originalNums = nums;
            this.originalLength = nums.length;
        }

        public int[] reset() {
            return this.originalNums;
        }

        public int[] shuffle() {

            final int[] shuffledNums = new int[this.originalLength];
            final Set<Integer> usedPositions = new HashSet<>();

            final Random random = new Random();
            int nextPosition = random.nextInt(this.originalLength);
            for (int i = 0; i < this.originalLength; i++) {
                while (usedPositions.contains(nextPosition)) {
                    nextPosition = random.nextInt(this.originalLength);
                }
                usedPositions.add(nextPosition);
                shuffledNums[i] = this.originalNums[nextPosition];
            }
            return shuffledNums;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */

}

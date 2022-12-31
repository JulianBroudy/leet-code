package io.broudy.leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * 
 * https://leetcode.com/problems/4sum/description/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        final List<List<Integer>> results = new ArrayList<>();

        final int numsLength = nums.length;
        if (numsLength < 4) {
            return results;
        }

        Arrays.sort(nums);

        int firstNumber, secondNumber, thirdNumber, fourthNumber, thirdNumberIndex, fourthNumberIndex;
        long newTarget, sum;
        for (int firstIndex = 0; firstIndex < numsLength; firstIndex++) {
            firstNumber = nums[firstIndex];

            for (int secondIndex = firstIndex + 1; secondIndex < numsLength; secondIndex++) {
                newTarget = Long.valueOf(target) - Long.valueOf(firstNumber)
                        - Long.valueOf((secondNumber = nums[secondIndex]));
                thirdNumberIndex = secondIndex + 1;
                fourthNumberIndex = numsLength - 1;
                while (thirdNumberIndex < fourthNumberIndex) {
                    thirdNumber = nums[thirdNumberIndex];
                    fourthNumber = nums[fourthNumberIndex];
                    sum = thirdNumber + fourthNumber;
                    if (sum == newTarget) {
                        results.add(Arrays.asList(firstNumber, secondNumber, thirdNumber, fourthNumber));
                        do {
                            thirdNumberIndex++;
                        } while (thirdNumberIndex < fourthNumberIndex
                                && nums[thirdNumberIndex - 1] == nums[thirdNumberIndex]);
                        do {
                            fourthNumberIndex--;
                        } while (fourthNumberIndex > fourthNumberIndex
                                && nums[fourthNumberIndex] == nums[fourthNumberIndex + 1]);
                    } else if (sum < newTarget) {
                        do {
                            thirdNumberIndex++;
                        } while (thirdNumberIndex < fourthNumberIndex
                                && nums[thirdNumberIndex - 1] == nums[thirdNumberIndex]);
                    } else {
                        do {
                            fourthNumberIndex--;
                        } while (fourthNumberIndex > fourthNumberIndex
                                && nums[fourthNumberIndex] == nums[fourthNumberIndex + 1]);
                    }

                }

                while (secondIndex < numsLength - 1 && nums[secondIndex] == nums[secondIndex + 1]) {
                    secondIndex++;
                }
            }

            while (firstIndex < numsLength - 1 && nums[firstIndex] == nums[firstIndex + 1]) {
                firstIndex++;
            }
        }

        return results;
    }
}

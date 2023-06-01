package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array">26. Remove Duplicates from Sorted Array</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int indexOfLastUniqueNumber = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[indexOfLastUniqueNumber] != nums[i]) {
				nums[++indexOfLastUniqueNumber] = nums[i];
			}
		}
		return indexOfLastUniqueNumber + 1;
	}
}
package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/">80. Remove Duplicates from Sorted Array II</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class RemoveDuplicatesFromSortedArray2 {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 1, 2, 2, 3};
		System.out.println(removeDuplicates(nums));
	}

	private static int removeDuplicates(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int indexOfLastUniqueNumber = 0;
		boolean secondShow = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[indexOfLastUniqueNumber] != nums[i]) {
				nums[++indexOfLastUniqueNumber] = nums[i];
				secondShow = false;
			} else if (!secondShow) {
				nums[++indexOfLastUniqueNumber] = nums[i];
				secondShow = true;
			}
		}
		return indexOfLastUniqueNumber + 1;
	}

}

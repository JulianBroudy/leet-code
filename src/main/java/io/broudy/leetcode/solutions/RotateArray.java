package io.broudy.leetcode.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/rotate-array">189. Rotate Array</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class RotateArray {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2};
		int k = 3;
		System.out.println(Arrays.toString(nums));
		rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}

	private static void rotate(int[] nums, int k) {
		final int newK = nums.length < k ? k % nums.length : k;
		if (newK != 0 && newK != nums.length) {
			int[] nums2 = Arrays.copyOfRange(nums, nums.length - newK, nums.length);
			System.arraycopy(nums, 0, nums, newK, nums.length - newK);
			System.arraycopy(nums2, 0, nums, 0, newK);
		}
	}

}

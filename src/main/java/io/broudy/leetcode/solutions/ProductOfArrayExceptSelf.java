package io.broudy.leetcode.solutions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class ProductOfArrayExceptSelf {
	public static void main(String[] args) {
		//		int[] intArray = new int[]{-1, 1, 0, -3, 3};
		int[] intArray = new int[]{1, 2, 3, 4};
		System.out.println(Arrays.toString(productExceptSelf(intArray)));
	}

	private static int[] productExceptSelf(int[] nums) {
		final int[] result = new int[nums.length];
		Arrays.fill(result, 1);
		int currentProduct = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] *= currentProduct;
			currentProduct *= nums[i];
		}
		currentProduct = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= currentProduct;
			currentProduct *= nums[i];
		}
		return result;
	}

	private static int[] productExceptSelf2(int[] nums) {
		final int[] prefix = new int[nums.length];
		final int[] suffix = new int[nums.length];
		prefix[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] * nums[i - 1];
		}
		suffix[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] * nums[i + 1];
		}
		final int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = prefix[i] * suffix[i];
		}
		return result;
	}

	private static int[] productExceptSelf3(int[] nums) {
		final int[] occurrences = new int[61]; // -30 <= nums[i] <= 30
		for (Integer num : nums) {
			occurrences[num + 30]++;
		}
		final int[] result = new int[nums.length];
		int product;
		for (int j = 0; j < nums.length; j++) {
			product = 1;
			for (int i = -30; i < 31; i++) {
				product *= Math.pow(i, i == nums[j] ? occurrences[i + 30] - 1 : occurrences[i + 30]);
			}
			result[j] = product;
		}
		return result;
	}

}

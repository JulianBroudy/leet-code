package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/majority-element/">169. Majority Element</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class MajorityElement {
	public static void main(String[] args) {
		int[] intArray = new int[]{3, 3, 4};
		System.out.println(majorityElement(intArray));
	}

	private static int majorityElement(int[] nums) {
		int majorityElement = nums[0];
		int countOfCurrentMajorityElement = 0;
		for (int num : nums) {
			if (countOfCurrentMajorityElement == 0) {
				majorityElement = num;
			}
			countOfCurrentMajorityElement += majorityElement == num ? 1 : -1;
		}
		return majorityElement;
	}

}

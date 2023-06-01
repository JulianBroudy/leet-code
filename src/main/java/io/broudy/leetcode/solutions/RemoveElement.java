package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/remove-element/">27. Remove Element</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		int indexOfLastNonValNumber = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[indexOfLastNonValNumber++] = nums[i];
			}
		}
		return indexOfLastNonValNumber;
	}

}
package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii">45. Jump Game II</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class JumpGame2 {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 3, 0, 1, 4};
		System.out.println(jump(nums));
	}

	private static int jump(int[] nums) {
		int[] stepsToReachEnd = new int[nums.length];
		stepsToReachEnd[nums.length - 1] = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			int currentStep = 1;
			int minSteps = 20000000;
			while (currentStep <= nums[i]) {
				if (currentStep + i < nums.length) {
					if (currentStep + i == nums.length - 1) {
						minSteps = 0;
						break;
					}
					if (stepsToReachEnd[(currentStep) + i] != 0 && stepsToReachEnd[(currentStep) + i] < minSteps)
						minSteps = stepsToReachEnd[currentStep + i];
				}
				currentStep++;
			}
			stepsToReachEnd[i] = minSteps + 1;
		}
		return stepsToReachEnd[0];
	}

}

package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/jump-game">55. Jump Game</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class JumpGame {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 3, 1, 1, 4};
		System.out.println(canJump(nums));
	}

	private static boolean canJump(int[] nums) {
		if (nums.length == 1) return true;
		if (nums[0] == 0) return false;
		boolean[] reachesTheEnd = new boolean[nums.length];
		reachesTheEnd[nums.length - 1] = true;
		for (int i = nums.length - 2; i >= 0; i--) {
			int currentStep = 1;
			while (currentStep <= nums[i]) {
				if (currentStep + i < nums.length && reachesTheEnd[(currentStep++) + i]) {
					reachesTheEnd[i] = true;
					break;
				}
			}
		}
		return reachesTheEnd[0];
	}

}

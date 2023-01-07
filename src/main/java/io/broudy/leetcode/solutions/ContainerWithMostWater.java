package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">11. Container With Most Water</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea3(height));
	}

	public static int maxArea3(int[] height) {
		int maxArea = 0;
		int newArea;
		int leftPos, rightPos;
		leftPos = 0;
		rightPos = height.length - 1;
		while (leftPos < rightPos) {
			newArea = Math.min(height[leftPos], height[rightPos]) * (rightPos - leftPos);
			if (newArea > maxArea) {
				maxArea = newArea;
			}
			if (height[leftPos] < height[rightPos]) {
				leftPos++;
			} else {
				rightPos--;
			}
		}
		return maxArea;
	}

}

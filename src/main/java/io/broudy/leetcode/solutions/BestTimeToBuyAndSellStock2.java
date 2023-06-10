package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">122. Best Time to Buy and Sell Stock ||</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class BestTimeToBuyAndSellStock2 {
	public static void main(String[] args) {
		int[] prices = new int[]{7, 6, 4, 3, 1};
		System.out.println(maxProfit(prices));
	}

	private static int maxProfit(int[] prices) {
		int currentProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				currentProfit += prices[i] - prices[i - 1];
			}
		}
		return currentProfit;
	}

}

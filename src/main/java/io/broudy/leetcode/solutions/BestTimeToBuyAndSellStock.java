package io.broudy.leetcode.solutions;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a>.
 *
 * @author <a href="https://github.com/JulianBroudy">Julian Broudy</a>
 */
public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}

	private static int maxProfit(int[] prices) {
		int highestProfit = 0;
		int lowestPrice = prices[0];

		for (Integer price : prices) {
			if (price < lowestPrice) lowestPrice = price;
			else if (price - lowestPrice > highestProfit) highestProfit = price - lowestPrice;
		}
		return highestProfit;
	}

}

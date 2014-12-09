package bestTimeToBuyAndSellStockIII;
/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author HWT
 *
 */
public class Solution {
	public int maxProfit(int[] prices) {
		//break the transaction into left and right, DP each and get the max sum;
		int profit = 0;
        if (prices == null || prices.length == 0) {
        	return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        //DP left
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length - 1; i++) {
        	min = prices[i] < min ? prices[i] : min;
        	left[i] = left[i - 1] > prices[i] - min ? left[i - 1] : prices[i] - min;
        }
        //DP right
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
        	max = prices[i] > max ? prices[i] : max;
        	right[i] = right[i + 1] > max - prices[i] ? right[i + 1] : max - prices[i];
        }
        for (int i = 0; i < prices.length; i++) {
        	profit = profit > left[i] + right[i] ? profit : left[i] + right[i];
        }
        return profit;
    }
}


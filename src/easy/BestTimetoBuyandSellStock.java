package easy;

import java.util.Arrays;

/**
 * Created by rrr on 2017/3/24.
 * 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock {
    //穷举法，在iday卖出，计算与之前买入价格相减，返回最大值
    //无法通过OJ，超时
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profitMax = 0;
        int[] profit = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                profit[j] = prices[i] - prices[j];
                profitMax = Math.max(profitMax, profit[j]);
            }
        }
        return profitMax;
    }
   //The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm
    public static int maxProfit2(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    //设置一个min来记录最小买入价，计算最大收益并返回
    public int maxProfit3(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int max = 0, min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {

                min = prices[i];
            } else {
                if (prices[i] - min > profit) {
                    profit = prices[i] - min;
                }
            }
        }
        return profit;

    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(maxProfit2(nums));
        int[] nums2 = {1, 6};
        System.out.println(Arrays.toString(nums2));
        System.out.println(maxProfit(nums2));
    }
}

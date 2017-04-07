import java.util.Arrays;

/**
 * Created by rrr on 2017/4/7.
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 Design an algorithm to find the maximum profit.
 You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStockII {
    //因为可以多次交易，等价于计算所有大于0的差值的和
    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]-prices[i-1]>0)maxProfit+=prices[i]-prices[i-1];
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(maxProfit(nums));
        int[] nums2 = {1};
        System.out.println(Arrays.toString(nums2));
        System.out.println(maxProfit(nums2));
        int[] nums3 = {7, 6, 4, 3, 1};
        System.out.println(Arrays.toString(nums3));
        System.out.println(maxProfit(nums3));
    }
}

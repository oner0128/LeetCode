package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/6/19.
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    //dp O(n^2)111 ms   space O(n^2)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        int[] maxCol = new int[nums.length];
        //初始化第一行
        dp[0][0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[0]) dp[0][i] = 2;
            else dp[0][i] = 1;
            maxCol[i] = dp[0][i];
        }
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i][i] = maxCol[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) dp[i][j] = dp[i][i] + 1;
                else dp[i][j] = maxCol[j];
                maxCol[j] = maxCol[j] < dp[i][j] ? dp[i][j] : maxCol[j];
            }
        }
        for (int i : maxCol) if (i > maxLen) maxLen = i;
        return maxLen;
    }

    //dp O(n^2)66 ms   space O(n)
    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] maxCol = new int[nums.length];
        //初始化第一行
        for (int i = 0; i < nums.length; i++)
            maxCol[i] = 1;
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && maxCol[j] <= maxCol[i]) maxCol[j] = maxCol[i] + 1;
                maxLen = Math.max(maxLen, maxCol[j]);
            }
        return maxLen;
    }
    //LeetCode解法 dp O(n^2) 30 ms   space O(n)
    public int lengthOfLIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
    //LeetCode解法 dp and binary search
    // O(nlogn) 3 ms  Binary search takes log(n)log(n) time and it is called nn times.
    // space O(n)
    public static int lengthOfLIS4(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{2, 2}));
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 0, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
//        System.out.println(lengthOfLIS2(new int[]{2, 2}));
        System.out.println(lengthOfLIS4(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(lengthOfLIS4(new int[]{10, 9, 2, 5, 0, 7, 101, 18}));
        System.out.println(lengthOfLIS4(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}

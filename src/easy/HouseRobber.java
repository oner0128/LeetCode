package easy;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/29.
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        if (nums.length <= 3) {
            if (nums.length == 3) {
                res = Math.max(nums[1], nums[0] + nums[2]);
            } else {
                int i = 0;
                while (i < nums.length) if (res < nums[i]) res = nums[i];
            }
            return res;
        } else {
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[0] + nums[2];
            for (int i = 3; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            }
        }
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public static int rob2(int[] nums) {
        if(nums.length==0||nums==null)return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i<2)dp[i]=nums[i];
            else if (i==2)dp[i]=nums[0]+nums[2];
            else dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return dp.length==1?dp[nums.length - 1]:Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }
    //LeetCode
    //dp[i][1] means we rob the current house and dp[i][0] means we don't,
    public static int rob3(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 54, 6, 7, 9, 8, 4, 103, 1};
        System.out.println(rob2(nums));
    }
}

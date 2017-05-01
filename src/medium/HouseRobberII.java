package medium;

/**
 * Created by rrr on 2017/4/29.
 * 213. House Robber II
 * Note: This is an extension of House Robber.
 After robbing those houses on that street,
 the thief has found himself a new place for his thievery
 so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 Given a list of non-negative integers
 representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    //想不出来
    //难点:在决定偷最后一个房子时你无法知道前面最大的值是否偷了第一个房子
    //解决方案:分两步;第一步计算第一个房子到倒数前一个房子的最大值(即最后一个房子不偷)
    //第二步计算第二个房子到最后一个房子的最大值(即第一个房子不偷)
    //输出其中的大数
    public static int rob(int[] nums) {
        if(nums.length==0||nums==null)return 0;
        if(nums.length==1)return nums[0];
        int[][] dp = new int[nums.length+1][2];
        for (int i = 1; i < nums.length; i++) {//不偷最后一个房子
           dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
           dp[i][1]=nums[i-1]+dp[i-1][0];
        }
        int res1=Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
        dp = new int[nums.length+1][2];
        for (int i = 2; i <= nums.length; i++) {//不偷第一个房子
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=nums[i-1]+dp[i-1][0];
        }
        int res2=Math.max(dp[nums.length][0], dp[nums.length][1]);
        return Math.max(res1, res2);
    }
    //LeetCode解法
    public static int rob2(int[] nums) {
        if(nums.length==1)return nums[0];
        return Math.max(robHouse(nums,0,nums.length-1),robHouse(nums,1,nums.length));
    }

    private static int robHouse(int[] nums, int start, int end) {
        int preYes=0,preNo=0;
        for (int i = start; i <end; i++) {
            int temp=preNo;
            preNo=Math.max(preNo,preYes);
            preYes=nums[i]+temp;
        }
        return Math.max(preNo,preYes);
    }
}

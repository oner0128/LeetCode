package hard;

/**
 * Created by rrr on 2017/8/23.
 * 45. Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

 Note:
 You can assume that you can always reach the last index.
 */
public class JumpGameII {
    //不会
    //LeetCode解法  思路：将数组分层
    public int jump(int[] nums) {
        if (nums==null||nums.length<2)return 0;
        int jumps=0,curFarth=0,curEnd=0;
        for (int i = 0; i < nums.length-1; i++) {
            curFarth=Math.max(nums[i]+i,curFarth);
            if (i==curEnd){
                jumps++;
                curEnd=curFarth;
            }
        }
        return jumps;
    }
}

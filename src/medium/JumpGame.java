package medium;

import java.util.Stack;

/**
 * Created by rrr on 2017/4/7.
 * 55. Jump Game Add to List
 * DescriptionSubmissionsSolutions
 * Total Accepted: 114929
 * Total Submissions: 392189
 * Difficulty: Medium
 * Contributor: LeetCode
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    //Time Limit Exceeded
    //超时
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> lenStack = new Stack<>();
        int len = nums[0];
        int index = 0;
        indexStack.push(index);
        lenStack.push(len);
        while (!lenStack.isEmpty() && !indexStack.isEmpty()) {
            int i = 1;
            index = indexStack.pop();
            len = lenStack.pop();
            if (index + len >= nums.length - 1) return true;
            while (i <= len) {
                if (nums[index + i] > 0) {
                    indexStack.push(index + i);
                    lenStack.push(nums[index + i]);
                }
                i++;
            }
        }
        return false;
    }

    //Time Limit Exceeded
    //超时
    public boolean canJump2(int[] nums) {
        if (nums.length < 2) return true;
//        int len = nums[0];
//        int startIndex = 0;
        boolean[] hasIndex = {false};
        find(nums, 0, nums[0], hasIndex);
        return hasIndex[0];
    }

    private void find(int[] nums, int startIndex, int len, boolean[] hasIndex) {
        if (len <= 0) return;
        for (int i = len; i > 0; i--) {
            if (startIndex + len >= nums.length - 1 || hasIndex[0]) {
                hasIndex[0] = true;
                return;
            }
            find(nums, startIndex + i, nums[startIndex + i], hasIndex);
        }
    }

    //错误思路：从前往后遍历，相当于穷举法，虽然也能求出解但是O(n^n)
    //正确思路：应该从后往前遍历，利用贪婪算法O(n),即当前位置的值nums[i]加上位置序号是否大于等于last(即最大能到达的地方)
    public boolean canJump3(int[] nums) {
        int last=nums.length-1;
        for (int i = nums.length-2; i >=0 ; i--) {
            if (i+nums[i]>=last)last=i;
        }
        return last<=0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 4};
        System.out.println(new JumpGame().canJump(nums));
        System.out.println(new JumpGame().canJump3(nums));
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(new JumpGame().canJump(nums2));
        System.out.println(new JumpGame().canJump3(nums2));
        int[] nums3 = {1, 1, 3};
        System.out.println(new JumpGame().canJump(nums3));
        System.out.println(new JumpGame().canJump3(nums3));
        int[] nums4 = {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
        System.out.println(new JumpGame().canJump2(nums4));
        System.out.println(new JumpGame().canJump3(nums4));
    }
}

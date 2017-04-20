package easy;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/7.
 * 189. Rotate Array Add to List
 DescriptionSubmissionsSolutions
 Total Accepted: 118185
 Total Submissions: 493445
 Difficulty: Easy
 Contributor: LeetCode
 Rotate an array of n elements to the right by k steps.
 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {
    //time O(n) space O(k)
    public static void rotate(int[] nums, int k) {
        k=k%nums.length;
        int[]extra=new int[k];
        for (int i = 0; i < k; i++) {
            extra[i]=nums[nums.length-k+i];
        }
        for (int i = nums.length-k-1; i >=0 ; i--) {
            nums[i+k]=nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i]=extra[i];
        }
    }
    //time O(n^2) space O(1)
    public static void rotate2(int[] nums, int k) {
        k=k%nums.length;
        int tmp=0;
        for (int i = 0; i < k; i++) {
            tmp=nums[nums.length-1];
            for (int j = nums.length-2; j >=0 ; j--) {
                nums[j+1]=nums[j];
            }
            nums[0]=tmp;
        }
    }
    //time O(n) space O(n)
    public static void rotate3(int[] nums, int k) {
        k=k%nums.length;
        int[]rotate=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotate[(i+k)%nums.length]=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=rotate[i];
        }

    }
    //LeetCode大神解法
    //time O(n) space O(1)
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(nums));
        rotate(nums,2); System.out.println(Arrays.toString(nums));
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(nums2));
        rotate2(nums2,2); System.out.println(Arrays.toString(nums2));
        int[] nums3 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(nums3));
        rotate3(nums3,2); System.out.println(Arrays.toString(nums3));
    }
}

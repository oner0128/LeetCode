package easy;

import java.util.Arrays;

/**
 * Created by rrr on 2017/2/14.
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int newLength = 1;
        for (int i = 0,j=0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {newLength++;
            nums[++j]=nums[i];}
        }
        System.out.println(Arrays.toString(nums));
        return newLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 3, 3, 4, 5};
        System.out.println(removeDuplicates(nums));
        int[] nums2 = {1,1,2};
        System.out.println(removeDuplicates(nums2));
        int[] nums3 = {1,1};
        System.out.println(removeDuplicates(nums3));
    }
}

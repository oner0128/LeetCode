package medium;

/**
 * Created by rrr on 2017/4/6.
 * 80. Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) return 0;
        int newLength = 1;
        int head = 0;
        int i = 1;
        boolean hasTwo = false;
        while (i < nums.length) {
            if (!hasTwo && nums[head] == nums[i]) {
                nums[++head] = nums[i];
                newLength++;
                hasTwo = true;
            } else if (nums[head] != nums[i]) {
                nums[++head] = nums[i];
                newLength++;
                hasTwo = false;
            }
            i++;
        }
        return newLength;
    }
    //LeetCode大神解法
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3, 3, 4, 5};
        System.out.println(removeDuplicates2(nums));
        int[] nums2 = {1, 1, 2,2,2,2,2,2};
        System.out.println(removeDuplicates(nums2));
        int[] nums3 = {1, 1, 1, 1, 2, 2, 3, 9};
        System.out.println(removeDuplicates(nums3));
        int[] nums4 = {1};
        System.out.println(removeDuplicates(nums4));
        int[] nums5 = {};
        System.out.println(removeDuplicates(nums5));
    }
}

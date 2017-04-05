import java.util.Arrays;

/**
 * Created by rrr on 2017/4/5.
 * 75. Sort Colors
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class SortColors {
    //two-pass
    public void sortColors(int[] nums) {
        int len = nums.length;
        int head = 0;
        for (int k = 0; k < len; k++) {
            if (nums[k] == 0) {
                swap(nums, head, k);
                head++;
            }
        }
        for (int k = head; k < len; k++) {
            if (nums[k] == 1) {
                swap(nums, head, k);
                head++;
            }
        }
    }

    private static void swap(int[] nums, int head, int k) {
        int tmp = nums[k];
        nums[k] = nums[head];
        nums[head] = tmp;
    }

    //one-pass
    public static void sortColors2(int[] nums) {
        int len = nums.length;
        int zero = 0, two = len - 1;
        for (int k = 0; k < len&&k<=two ; k++) {
            if (nums[k] == 0) {
                swap(nums, zero, k);
                zero++;
            } else if (nums[k] == 2) {
                swap(nums, two, k);
                two--;
                k--;
            }
        }
    }
    // LeetCode大神解法
    // 1-pass
    public void sortColors3(int[] nums) {

        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
    // LeetCode大神解法
    // 2-pass
    public void sortColors4(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 1, 2, 1, 1, 0, 2, 1, 1};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
        int[] nums2 = { 1, 1, 1, 1, 1, 1, 1, 2, 2, 0};
        sortColors2(nums2);
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = { 1,0};
        sortColors2(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}

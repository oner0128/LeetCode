package easy;

import java.util.Arrays;

/**
 * Created by rrr on 2017/3/24.
 * 167. Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 思路：因为数组是有序的，所以使用两点法，分别指向起始位和末位，若两数相加小于Target则head++，若两数相加大于Target则rear--，
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        int head = 0, rear = numbers.length - 1;
        while (head < rear) {
            if (numbers[head] + numbers[rear] == target) {
                results[0] = head + 1;
                results[1] = rear + 1;
                break;
            }
            while (numbers[head] + numbers[rear] < target)
                head++;
            while (numbers[head] + numbers[rear] > target)
                rear--;

        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(twoSum(nums, 1)));
        int[] nums3 = {1, 10, 1, 5, 3, 12, 11};
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(twoSum(nums3, 12)));
        int[] nums2 = {1, 0, 3, 9, 4};
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(twoSum(nums2, 10)));
        int[] nums4 = {0};
        Arrays.sort(nums4);
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(twoSum(nums4, 1)));
        int[] nums5 = {0, 0};
        Arrays.sort(nums5);
        System.out.println(Arrays.toString(nums5));
        System.out.println(Arrays.toString(twoSum(nums5, 0)));
    }
}

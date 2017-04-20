package easy;

import java.util.*;

/**
 * Created by rrr on 2017/4/10.
 * 532. K-diff Pairs in an Array
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class KdiffPairsInAnArray {
    //HashMap   O（n）
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length < 2) return 0;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() > 1) pairs++;
            } else {
                if (map.containsKey(entry.getKey() + k)) pairs++;
            }
        }
        return pairs;
    }

    //Two pointers   O（nlogn）
    public static int findPairs2(int[] nums, int k) {
        if (k < 0 || nums.length < 2) return 0;
        int pairs = 0;
        Arrays.sort(nums);
        int head = 0, rear = 1;
        while (rear < nums.length) {
            if (k == 0) {
                if (nums[rear] - nums[head] == k) {
                    pairs++;
                    while (head < nums.length - 1 && nums[head] == nums[head + 1]) head++;
                    rear = head + 2;
                    head++;
                } else head = rear++;
            } else {
                if (nums[rear] - nums[head] > k) head++;
                else if (nums[rear] - nums[head] < k) rear++;
                else {
                    pairs++;
                    while (rear < nums.length - 1 && nums[rear] == nums[rear + 1]) rear++;
                    while (head < nums.length - 1 && nums[head] == nums[head + 1]) head++;
                    head++;
                    rear++;
                }
            }
        }
        return pairs;
    }

    //HashSet  O（n）
    public static int findPairs3(int[] nums, int k) {
        if (k < 0 || nums.length < 2) return 0;
        int pairs = 0;
        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) pairs++;
//            else {
//                int diff1 = Math.abs(k - nums[i]);
//                int diff2 = Math.abs(k + nums[i]);
//                set.add(diff1);
//                set.add(diff2);
//                while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
//            }
//        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 1, 5};
        System.out.println(Arrays.toString(nums));
        System.out.println(findPairs2(nums, 0));
        System.out.println(findPairs3(nums, 0));
        System.out.println(Arrays.toString(nums));
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(nums2));
        System.out.println(findPairs2(nums2, 2));
        System.out.println(findPairs3(nums2, 2));
        System.out.println(Arrays.toString(nums2));
        int[] nums3 = {1, 1, 1, 2, 2};
        System.out.println(Arrays.toString(nums3));
        System.out.println(findPairs2(nums3, 0));
        System.out.println(findPairs3(nums3, 0));
        System.out.println(Arrays.toString(nums3));
    }
}

package easy;

/**
 * Created by rrr on 2017/2/13.
 * 485 Max Consecutive Ones
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * 找出连续的1 的最大个数
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length < 1) return  0 ;
        int max = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                 max = Math.max(max,i - j+1);
            } else j = i+1;
        }
        return max;
    }
    public static int findMaxConsecutiveOnes2(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
        int[] nums2 = {1,0};
        System.out.println(findMaxConsecutiveOnes(nums2));
        int[] nums3 = {1, 1, 0, 1, 0, 0, 0, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums3));
    }
}

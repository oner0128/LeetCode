package medium;

import java.util.Random;

/**
 * Created by rrr on 2017/7/8.
 * 384. Shuffle an Array
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleAnArray {
    private int[] nums;
    private int[] OriginalNums;
    private  static Random random=new Random(47);
    public ShuffleAnArray(int[] nums) {
        this.nums = nums.clone();this.OriginalNums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return OriginalNums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (nums.length==0)return OriginalNums;
        int i=random.nextInt(nums.length),j=random.nextInt(nums.length);
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
        return nums;
    }
}

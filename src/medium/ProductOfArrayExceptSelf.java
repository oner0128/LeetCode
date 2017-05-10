package medium;

import sun.security.provider.Sun;

import java.util.Arrays;

/**
 * Created by rrr on 2017/3/24.
 * 238. Product of Array Except Self
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * 思路一：//先统计出数组中0的个数，若有两个零则输出数组全为0，若有一个0，则只需计算该0的位置即可返回数组。
 *          若没有0，则先计算所有数的乘积，对于每个output[i]=mul/nums[i]
 * 思路二：//先计算当前位置i前所有的数乘积，再计算当前位置i后所有的数的乘积
 */
public class ProductOfArrayExceptSelf {
    //先统计出数组中0的个数，若有两个零则输出数组全为0，若有一个0，则只需计算该0的位置即可返回数组。
    public static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) return nums.length == 0 ? new int[]{} : new int[]{1};
        int[] output = new int[nums.length];
        int zerosCount = 0;
        for (int i : nums)
            if (i == 0) zerosCount++;
        if (zerosCount > 1) return output;
        else if (zerosCount == 1) return onerZero(nums, output);
        else return noZero(nums, output);
    }

    private static int[] noZero(int[] nums, int[] output) {
        int sum = 1;
        int i = 0;
        while (i < nums.length) {
            sum *= nums[i++];
        }
        for (int j = 0; j < nums.length; j++) {
            output[j] = sum / nums[j];
        }
        return output;
    }

    private static int[] onerZero(int[] nums, int[] output) {
        int zeroIndex = 0;
        while (zeroIndex < nums.length)
            if (nums[zeroIndex++] == 0)
                break;
        zeroIndex -= 1;
        int sum = 1;
        int head = 0, end = nums.length - 1;
        while (head < nums.length) {
            if (head == zeroIndex) {
                head++;
                continue;
            }
            sum = sum * nums[head++];
        }
        output[zeroIndex] = sum;
        return output;
    }

    private static int[] noZero2(int[] nums, int[] output) {
        int len = nums.length;
        int leftMult = 1, rightMult = 1;

        for (int i = len - 1; i >= 0; i--) {
            output[i] = rightMult;
            rightMult *= nums[i];
        }
        for (int j = 0; j < len; j++) {
            output[j] *= leftMult;
            leftMult *= nums[j];

        }
        return output;
    }
    //思路二
    public int[] productExceptSelf2(int[] nums) {

        int len = nums.length;
        int [] output = new int[len];

        int leftMult = 1, rightMult = 1;

        for(int i = len-1; i >= 0; i--){
            output[i] = rightMult;
            rightMult *= nums[i];
        }
        for(int j = 0; j < len; j++){
            output[j] *= leftMult;
            leftMult *= nums[j];
        }

        return output;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 0};
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        int[] nums3 = {1, 10, 1, 5, 3, 12, 11};
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(productExceptSelf(nums3)));
        int[] nums2 = {1, 0, 3, 9, 4};
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));
        int[] nums4 = {0};
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(productExceptSelf(nums4)));
        int[] nums5 = {1, 0};
        System.out.println(Arrays.toString(nums5));
        System.out.println(Arrays.toString(productExceptSelf(nums5)));
    }
}

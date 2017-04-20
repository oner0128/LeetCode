package easy;

/**
 * Created by rrr on 2017/3/26.
 * 268. Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * //LeetCode大神解法
 // The basic idea is to use XOR operation. We all know that a^b^b =a,
 // which means two xor operations with the same number will eliminate the number and reveal the original number.
 // In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers,
 // the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
 XOR=0,i=0
 XOR=XOR^i^nums[i];
 return XOR^i
 算法流程
 nums = {0, 3, 1};
 0^0^0^1^3^2^1 ,return XOR^i ,0^0^0^1^3^2^1^3
 即0^0^0^1^1^3^3^2 =0^2=2因此得到missingNum=2
 */
public class MissingNumber {
    //错误思路，若数组的数不按升序排列则失效
    public static int missingNumber(int[] nums) {
        boolean isEven = true;
        for (int i = 0; i < nums.length; i++) {
            isEven = i % 2 == 0 ? true : false;
            if ((nums[i] & 1) == 0 && !isEven) return i;
            if ((nums[i] & 1) == 1 && isEven) return i;
        }
        return 0;
    }

    //因为数组是等比数列，计算出前N项和减去数组之和即为缺少的数。
    //运行时间 2ms
    public static int missingNumber2(int[] nums) {
        int sum = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            currentSum += i + 1;
        }
        return currentSum - sum;
    }

    //思路同上，但是使用等比数列求和公式
    //运行时间 1ms
    public static int missingNumber3(int[] nums) {
        int sum = 0, n = nums.length;
        int currentSum = n * (1 + n) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return currentSum - sum;
    }
    //LeetCode大神解法
    // The basic idea is to use XOR operation. We all know that a^b^b =a,
    // which means two xor operations with the same number will eliminate the number and reveal the original number.
    // In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers,
    // the index and value should be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
    public static int missingNumber4(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    //LeetCode大神解法，跟方法3思路一样，但是代码更简洁
    // Hey guys, since the n numbers are from [0, n], we can just add all the numbers from [0, n] together
    // and minus the sum of the n-1 numbers in array.
    // Just like this.
    public static int missingNumber5(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
        System.out.println(missingNumber4(nums));
    }
}

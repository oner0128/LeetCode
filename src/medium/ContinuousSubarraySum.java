package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rrr on 2017/8/28.
 * 523. Continuous Subarray Sum
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * <p>
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * Example 2:
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * Note:
 * The length of the array won't exceed 10,000.
 * You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum {
    /*
    * Submission Result: Time Limit Exceeded More Details
    Last executed input:
    [23,2,4,6,7]
    -6*/
    public boolean checkSubarraySum_wrong(int[] nums, int k) {
        Set<Integer> preSum = new HashSet<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;
            int power = 1;
            while (sum - k * power >= 0) {//未考虑当sum-k*power相减永远为正的情况
                if (preSum.contains(sum - k * power)) return true;
                power++;
            }
            preSum.add(sum);
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        preSum.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;//要找出sum[0,j]-sum[0,i-1]=n*k等价于sum[0,j]%k-sum[0,i-1]%k=(sum[j-1]+num[i])%k
            if (preSum.containsKey(sum) && preSum.get(sum) != i - 1) return true;
            else preSum.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{2, 2, 10, 6, 7}, 6));
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, -6));
    }
}

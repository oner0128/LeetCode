package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/8/28.
 * 560. Subarray Sum Equals K
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    //找到连续子阵列的总数,不是找到满足k的subarray中的个数
    /*Submission Result: Wrong Answer More Details

Input:
[1,2,1,2,1]
3
Output:
2
Expected:
4
    * */
    public int subarraySum_wrong(int[] nums, int k) {
        if (nums == null) return 0;
        int lo = 0, hi = 0, sum = 0;
        while (lo <= hi && hi < nums.length) {
            if (sum == k) return hi - lo;//错误
            else if (sum < k) {
                sum += nums[hi++];
            } else {
                if (lo != hi)
                    sum -= nums[lo++];
                else {
                    sum = 0;
                    lo++;
                    hi++;
                }
            }
        }
        return 0;
    }
    //map
    public int subarraySum(int[] nums, int k) {
        if (nums == null) return 0;
        int sum = 0, count = 0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for (int n: nums) {
            sum+=n;
            if (map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 5, 1, 2, 5, 1
        }, 0));
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1, 1, 1
        }, 2));
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1,2,1,2,1
        }, 3));
    }
}

package medium;

import sun.security.provider.Sun;

/**
 * Created by rrr on 2017/4/6.
 * 209. Minimum Size Subarray Sum
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    //自己解没成功，问题出在若何递减start 或 end问题上
    public static int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int minLen = nums.length;
//        boolean target=false;
        int start = 0, end = nums.length - 1;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= s) return 1;
            sum += nums[i];
        }
        if (sum < s) return 0;
        while (start < end) {
            if (sum >= s) {
                minLen = Math.min(minLen, end - start + 1);
            } else break;
            if (nums[start] + nums[start + 1] < nums[end - 1] + nums[end]) sum -= nums[start++];
            else if (nums[start] + nums[start + 1] > nums[end - 1] + nums[end]) sum -= nums[end--];
            else if (start + 1 < end && nums[start + 2] >= nums[end - 2]) sum -= nums[end--];
            else sum -= nums[start++];
        }
        return minLen;
    }

    //LeetCode大神解法
    //   O(N) solutions,  O(1) space
    public static int minSubArrayLen2(int s, int[] nums) {
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int i = 0, counter = 0;
        while (i < nums.length) {
            if (nums[i] >= s) return 1;
            sum += nums[i++];
            while (sum >= s) {
                minLen = Math.min(minLen, i - counter);
                sum -= nums[counter++];
            }
        }
        return minLen == Integer.MIN_VALUE ? 0 : minLen;
    }
    //LeetCode大神解法2
    //   O(N) solutions,  O(1) space
    //上一个解法的优化
    public static int solveN(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        while (end < nums.length) {
            while (end < nums.length && sum < s) sum += nums[end++];
            if (sum < s) break;
            while (start < end && sum >= s) sum -= nums[start++];
            if (end - start + 1 < minLen) minLen = end - start + 1;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    //LeetCode大神解法3
    // O(NLogN) solutions,  O(1) space
    private static int solveNLogN(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
//        int[] pre = {3, 3, 1, 2, 4, 3};
//        System.out.println(minSubArrayLen(7, pre));
//        System.out.println(minSubArrayLen2(7, pre));
//        int[] pre3 = {3, 4, 1, 2, 1, 3};
//        System.out.println(minSubArrayLen(7, pre3));
//        System.out.println(minSubArrayLen2(7, pre3));
        int[] pre2 = {5, 1, 1, 4, 3};
//        System.out.println(minSubArrayLen(7, pre2));
        System.out.println(minSubArrayLen2(7, pre2));
        int[] pre3 = {2, 10, 1, 1, 2, 11, 1};
//        System.out.println(minSubArrayLen(14, pre3));
        System.out.println(minSubArrayLen2(14, pre3));

        int[] pre4 = {5334, 6299, 4199, 9663, 8945, 3566, 9509, 3124, 6026, 6250, 7475, 5420, 9201, 9501, 38, 5897, 4411, 6638, 9845, 161, 9563, 8854, 3731, 5564, 5331, 4294, 3275, 1972, 1521, 2377, 3701, 6462, 6778, 187, 9778, 758, 550, 7510, 6225, 8691, 3666, 4622, 9722, 8011, 7247, 575, 5431, 4777, 4032, 8682, 5888, 8047, 3562, 9462, 6501, 7855, 505, 4675, 6973, 493, 1374, 3227, 1244, 7364, 2298, 3244, 8627, 5102, 6375, 8653, 1820, 3857, 7195, 7830, 4461, 7821, 5037, 2918, 4279, 2791, 1500, 9858, 6915, 5156, 970, 1471, 5296, 1688, 578, 7266, 4182, 1430, 4985, 5730, 7941, 3880, 607, 8776, 1348, 2974, 1094, 6733, 5177, 4975, 5421, 8190, 8255, 9112, 8651, 2797, 335, 8677, 3754, 893, 1818, 8479, 5875, 1695, 8295, 7993, 7037, 8546, 7906, 4102, 7279, 1407, 2462, 4425, 2148, 2925, 3903, 5447, 5893, 3534, 3663, 8307, 8679, 8474, 1202, 3474, 2961, 1149, 7451, 4279, 7875, 5692, 6186, 8109, 7763, 7798, 2250, 2969, 7974, 9781, 7741, 4914, 5446, 1861, 8914, 2544, 5683, 8952, 6745, 4870, 1848, 7887, 6448, 7873, 128, 3281, 794, 1965, 7036, 8094, 1211, 9450, 6981, 4244, 2418, 8610, 8681, 2402, 2904, 7712, 3252, 5029, 3004, 5526, 6965, 8866, 2764, 600, 631, 9075, 2631, 3411, 2737, 2328, 652, 494, 6556, 9391, 4517, 8934, 8892, 4561, 9331, 1386, 4636, 9627, 5435, 9272, 110, 413, 9706, 5470, 5008, 1706, 7045, 9648, 7505, 6968, 7509, 3120, 7869, 6776, 6434, 7994, 5441, 288, 492, 1617, 3274, 7019, 5575, 6664, 6056, 7069, 1996, 9581, 3103, 9266, 2554, 7471, 4251, 4320, 4749, 649, 2617, 3018, 4332, 415, 2243, 1924, 69, 5902, 3602, 2925, 6542, 345, 4657, 9034, 8977, 6799, 8397, 1187, 3678, 4921, 6518, 851, 6941, 6920, 259, 4503, 2637, 7438, 3893, 5042, 8552, 6661, 5043, 9555, 9095, 4123, 142, 1446, 8047, 6234, 1199, 8848, 5656, 1910, 3430, 2843, 8043, 9156, 7838, 2332, 9634, 2410, 2958, 3431, 4270, 1420, 4227, 7712, 6648, 1607, 1575, 3741, 1493, 7770, 3018, 5398, 6215, 8601, 6244, 7551, 2587, 2254, 3607, 1147, 5184, 9173, 8680, 8610, 1597, 1763, 7914, 3441, 7006, 1318, 7044, 7267, 8206, 9684, 4814, 9748, 4497, 2239};
        System.out.println(minSubArrayLen(697439, pre4));
        System.out.println(minSubArrayLen2(697439, pre4));
        int[] pre5 = {10, 1, 1, 1, 1, 0, 0, 10, 2, 1};
        System.out.println(minSubArrayLen(13, pre3));
        System.out.println(minSubArrayLen2(13, pre5));
        System.out.println(solveNLogN(13, pre5));
    }
}

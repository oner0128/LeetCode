package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by rrr on 2017/4/10.
 * 136. Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    //HashTable time O(n) space O(n)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) if (entry.getValue() == 1) return entry.getKey();
        return 0;
    }

    //time O(n) space O(0)
    //1,3,2,2,3
    //位操作，异或 1^3^2^2^3=1
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int num : nums) res = res ^ num;
        return res;
    }
}

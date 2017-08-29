package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rrr on 2017/8/28.
 * 594. Longest Harmonious Subsequence
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {
    /*Submission Result: Wrong Answer More Details
    Input:
        [1,2,3,4]
    Output:
        4
    Expected:
        2
        思路错误：当前求的是数组中连续递增的最大个数，未满足题目条件最大最小值
    * */
    public int findLHS_Wrong(int[] nums) {
        if (nums==null)return 0;
        Set<Integer>set=new HashSet<>();
        int count=0;
        for (int n:nums){
            if (set.contains(n)||set.contains(n-1)||set.contains(n+1))count++;
            set.add(n);
        }
        return count==0?0:count+1;
    }
    public int findLHS(int[] nums) {
        if (nums==null)return 0;
        Map<Integer,Integer> map=new HashMap<>();
        int maxCount=0;
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
           int less=map.getOrDefault(n-1,0),more=map.getOrDefault(n+1,0);//最大最小值差值为1，只能+1或-1的一个
           maxCount=Math.max(Math.max(less,more)+map.get(n),maxCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(new LongestHarmoniousSubsequence().findLHS(new int[]{3,2,0,0,0,3,2,2,0,2,2,1,2,3,1,0,2,3,2,3,3,2,1,0,3,3,1}));
    }
}

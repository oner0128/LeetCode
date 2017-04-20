package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rrr on 2017/4/5.
 * 128. Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * //自己完全想不出来
 */
public class LongestConsecutiveSequence {
    /*We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence.
     For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
    Whenever a new element n is inserted into the map, do two things:
     1.See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
    Variables left and right will be the length of those two sequences,
    while 0 means there is no sequence and n will be the boundary point later.
    Store (left + right + 1) as the associated value to key n into the map.
     2.Use left and right to locate the other end of the sequences to the left and right of n respectively,
    and replace the value with the new length.
    Everything inside the for loop is O(1) so the total time is O(n). Please comment if you see something wrong. Thanks.*/
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum;
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                // sum: length of the sequence n is in
                sum = left + right + 1;
                map.put(num, sum);
                // keep track of the max length
                max = Math.max(max, sum);
                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(num - left, sum);
                map.put(num + right, sum);
            } else continue;
        }
        return max;
    }
    //Using a set to collect all elements that hasn't been visited. search element will be O(1) and eliminates visiting element again.
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count;
        int max = 0;
        for (int num : nums) set.add(num);
        for (int num : nums) {
            if (set.remove(num)) {
                int left = num ;
                int right = num ;
                while (set.remove(left-1)) left--;
                count = num - left + 1;
                while (set.remove(right+1)) right++;
                count += right - num ;
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
    }
}

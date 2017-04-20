package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/4.
 * 78. medium.Subsets
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 提示：Array Backtracking Bit Manipulation
 * 思路（自己完全想不出来）：
 */
public class Subsets {

    public static List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res,new ArrayList<Integer>(),nums,0);
        return res;
    }

    private static void backtracking(List<List<Integer>> res, ArrayList<Integer> set, int[] nums, int start) {
        res.add(new ArrayList<>(set));
        for (int i = start; i < nums.length; i++) {
            set.add(nums[i]);
            backtracking(res,set,nums,i+1);
            set.remove(set.size()-1);
        }
    }


    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets2(nums));
    }
}

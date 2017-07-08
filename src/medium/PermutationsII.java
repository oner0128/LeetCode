package medium;

import java.util.*;

/**
 * Created by rrr on 2017/5/23.
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {
    //LeetCode解法 9ms
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtracking(nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private static void backtracking(int[] nums, List<List<Integer>> res, ArrayList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) res.add(new ArrayList<>(list));
        else for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtracking(nums, res, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}

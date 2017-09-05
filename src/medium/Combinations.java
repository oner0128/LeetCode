package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrr on 2017/9/4.
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    //
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, n, 0, k, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(int start, int n, int num, int k, List<List<Integer>> res, ArrayList<Integer> integers) {
        if (integers.size() == k) res.add(new ArrayList<>(integers));
        else {
            for (int i = start; i <= n; i++) {
                integers.add(i);
                helper(i, n, num + 1, k, res, integers);
                integers.remove(integers.size() - 1);
            }
        }
    }
}

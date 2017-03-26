import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/3/26.
 * 39. Combination Sum
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * <p>
 * Tag Array Backtracking
 */
public class CombinationSum {
    //穷举法
    //无法通过Submission Details
/*100 / 168 test cases passed.
            Status: Wrong Answer
    Submitted: 1 minute ago
    Input:
            [1,2]
            4
    Output:
            [[1,1,2],[2,2]]
    Expected:
            [[1,1,1,1],[1,1,2],[2,2]]
            写了三层循环，但是结果可由四个数相加而得。
           因此无法用穷举法求解。
            */

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (candidates[i] == target) results.add(Arrays.asList(candidates[i]));
            for (int j = i; j < candidates.length; j++) {
                if (candidates[i] + candidates[j] > target) break;
                if (candidates[i] + candidates[j] == target) results.add(Arrays.asList(candidates[i], candidates[j]));
                for (int k = j; k < candidates.length; k++) {
                    if (candidates[i] + candidates[j] + candidates[k] > target) break;
                    if (candidates[i] + candidates[j] + candidates[k] == target)
                        results.add(Arrays.asList(candidates[i], candidates[j], candidates[k]));
                }
            }
        }
        return results;
    }

    static List<List<Integer>> results = new ArrayList<>();

    //回溯法
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        for (int i = 0; i < candidates.length; i++) {
            if (equalTarget(candidates[i], target)) results.add(Arrays.asList(candidates[i]));
            for (int j = i; j < candidates.length; j++) {
                if (candidates[i] + candidates[j] == target) results.add(Arrays.asList(candidates[i], candidates[j]));
                for (int k = j; k < candidates.length; k++) {
                    if (candidates[i] + candidates[j] + candidates[k] == target)
                        results.add(Arrays.asList(candidates[i], candidates[j], candidates[k]));
                }
            }
        }
        return results;
    }

    private static boolean equalTarget(int candidate, int target) {
        if (candidate == target) return true;
        return false;
    }

    //回溯法，LeetCode大神解法
    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }//for
        }//if
        else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

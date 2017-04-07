import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/6.
 * 40. Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(candidates);
        backtacking(res,new ArrayList<Integer>(),candidates,target,0);
        return res;
    }

    private static void backtacking(List<List<Integer>> res, ArrayList<Integer> integers, int[] candidates, int target, int start) {
        if (target==0&&!res.contains(integers))res.add(new ArrayList<>(integers));
        else if (target>0)for (int i = start; i < candidates.length&&candidates[i]<=target; i++) {
            integers.add(candidates[i]);
            backtacking(res,integers,candidates,target-candidates[i], i+1);
            integers.remove(integers.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum3(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(candidates);
        backtacking3(res,new ArrayList<Integer>(),candidates,target,0);
        return res;
    }
    //LeetCode解法   在循环中加入去除重复数字的条件
    private static void backtacking3(List<List<Integer>> res, ArrayList<Integer> integers, int[] candidates, int target, int start) {
        if (target==0)res.add(new ArrayList<>(integers));
        else for (int i = start; i < candidates.length&&candidates[i]<=target; i++) {
            if (i>start&&candidates[i]==candidates[i-1])continue;
            integers.add(candidates[i]);
            backtacking3(res,integers,candidates,target-candidates[i], i+1);
            integers.remove(integers.size()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(combinationSum3(new int[]{2, 3, 2, 7,5}, 7));
        System.out.println(combinationSum3(new int[]{2, 2, 1, 1,1,4}, 5));
    }
}

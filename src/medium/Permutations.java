package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rrr on 2017/5/23.
 * 46. Permutations
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {
    //10ms
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        if (nums==null||nums.length==0)return res;
        backtracking(nums,0,res,new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, int start, List<List<Integer>> res, ArrayList<Integer> list) {
        if (start==nums.length)res.add(new ArrayList<>(list));
        else for (int i = 0; i <nums.length; i++) {
            if (list.contains(nums[i]))continue;
            list.add(nums[i]);
            backtracking(nums,start+1,res,list);
            list.remove(list.size()-1);
        }
    }
    //LeetCode大神解法 8ms
    public static List<List<Integer>> permute2(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(permute2(new int[]{1,2,3}));
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/6.
 * 90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 Note: The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsII {
    //Submission Result: Wrong Answer
/*    Input:
            [4,4,4,1,4]
    Output:
            [[],[4],[4,4],[4,4,4],[4,4,4,1],[4,4,4,1,4],[4,4,4,4],[4,4,1],[4,4,1,4],[4,1],[4,1,4],[1],[1,4]]
    Expected:
            [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]*/
//未考虑数组是否有序
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        backtracking(res,new ArrayList<Integer>(),nums,0);
        return res;
    }
    //在回溯前先对数组排序
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res,new ArrayList<Integer>(),nums,0);
        return res;
    }
    //LeetCode大神解法   迭代
    public static List<List<Integer>> subsetsWithDup3(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        Arrays.sort(nums);
        int count;
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length;) {
            count=0;
            while (count+i<nums.length&&nums[count+i]==nums[i])count++;
            int size=res.size();
            for (int k=0;k<size;k++) {
                List<Integer>newList=new ArrayList<>(res.get(k));
                for (int j = 0; j < count; j++) {
                    newList.add(nums[i]);
                    res.add(new ArrayList<>(newList));
                }
            }
            i+=count;
        }
        return res;
    }
    private static void backtracking(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
        if (!res.contains(list)){
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(res,list,nums,i+1);
            list.remove(list.size()-1);}
        }
    }
    public static void main(String[] args) {
        int[] nums={1,2,2,3};
        System.out.println(subsetsWithDup(nums));
        int[] nums2={2,2,2};
        System.out.println(subsetsWithDup(nums2));int[] nums3={4,4,1};
        System.out.println(subsetsWithDup3(nums3));
    }
}

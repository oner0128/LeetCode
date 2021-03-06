package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rrr on 2017/8/4.
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) dfs(root, sum, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList<>(list));
        if (root.left != null)
            dfs(root.left, sum - root.val, res, list);
        if (root.right != null)
            dfs(root.right, sum - root.val, res, list);
        list.remove(list.size() - 1);
    }
    //Leetcode解法
    public List<List<Integer>> pathSum2(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum2(root,sum,currentResult,result);
        return result;
    }

    public void pathSum2(TreeNode root, int sum, List<Integer> currentResult,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum2(root.left, sum - root.val, currentResult, result);
            pathSum2(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}

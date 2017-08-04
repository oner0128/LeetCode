package easy;

/**
 * Created by rrr on 2017/8/4.
 * 112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    static boolean answer=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)dfs(root,sum);
        return answer;
    }

    private void dfs(TreeNode root, int sum) {
        if (root.left==null&&root.right==null&&sum==root.val)answer=true;
        if (root.left!=null)dfs(root.left,sum-root.val);
        if (root.right!=null)dfs(root.right,sum-root.val);
    }
    //LeetCode解法
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

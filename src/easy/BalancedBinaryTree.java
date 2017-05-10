package easy;

/**
 * Created by rrr on 2017/5/10.
 * 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    //leetcode解法 dfs
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root)!=-1;
    }
    private int dfsHeight(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left= dfsHeight(root.left);
        if (left==-1)return -1;
        int right= dfsHeight(root.right);
        if (right==-1)return -1;
        int diff=Math.abs(left-right);
        if (diff>1)return -1;
        return Math.max(left,right)+1;
    }
}

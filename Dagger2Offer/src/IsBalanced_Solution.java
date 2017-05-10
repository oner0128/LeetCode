import java.util.Stack;

/**
 * Created by rrr on 2017/5/10.
 * 题目描述
 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced_Solution {
    boolean isbalance=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        isBalanced(root);
        return isbalance;
    }

    public int isBalanced(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=isBalanced(root.left)+1;
        int right=isBalanced(root.right)+1;
        int diff=Math.abs(left-right);
        if (diff>1)isbalance=false;
        return left>right?left:right;
    }
}

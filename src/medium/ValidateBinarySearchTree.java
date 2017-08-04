package medium;

/**
 * Created by rrr on 2017/8/4.
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 Example 1:
 2
 / \
 1   3
 Binary tree [2,1,3], return true.
 Example 2:
 1
 / \
 2   3
 Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree {
   /* Runtime Error Message:
    Line 14: java.lang.NullPointerException
    Last executed input:
            [1,1]*/
    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        if (root.left==null&&root.right==null)return true;
        if (root.left.val>root.val||root.right.val<root.val)return false;//空指针
        return isValidBST(root.left)&&isValidBST(root.right);
    }
/*    Input:
            [10,5,15,null,null,6,20]
    Visualize
    Output:
            true
    Expected:
            false
            错误情况：未考虑当右子树的左子树6会小于root=10的情况*/
    public boolean isValidBST2(TreeNode root) {
        if (root==null)return true;
        if (root.left==null&&root.right==null)return true;
        if ((root.left!=null&&root.left.val>=root.val)||(root.right!=null&&root.right.val<=root.val))return false;
        return isValidBST2(root.left)&&isValidBST2(root.right);
    }
    public boolean isValidBST3(TreeNode root) {
        if (root==null)return true;
        boolean left=isValidLeft(root.val,root.left);
        boolean right=isValidRight(root.val,root.right);
        return left&&right;
    }

    private boolean isValidRight(int rootVal, TreeNode right) {
        if (right==null)return true;
        if (rootVal<=right.val)return false;
        if (right.left!=null&&(right.left.val>=right.val||right.left.val<=rootVal))return false;//判断右子树的左子树是否小于右子树并且要大于根节点
        return isValidLeft(right.val,right.left)&&isValidRight(right.val,right.right);
    }

    private boolean isValidLeft(int rootVal, TreeNode left) {
        if (left==null)return true;
        if (rootVal<=left.val)return false;
        if (left.right!=null&&(left.right.val<=left.val||left.right.val>=rootVal))return false;//判断左子树的右子树是否大于右子树并且要小于根节点
        return isValidLeft(left.val,left.left)&&isValidRight(left.val,left.right);
    }
}

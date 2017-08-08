package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rrr on 2017/8/4.
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * 2
 * / \
 * 1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 * 1
 * / \
 * 2   3
 * Binary tree [1,2,3], return false.
 */
public class ValidateBinarySearchTree {
    /* Runtime Error Message:
     Line 14: java.lang.NullPointerException
     Last executed input:
             [1,1]*/
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left.val > root.val || root.right.val < root.val) return false;//空指针
        return isValidBST(root.left) && isValidBST(root.right);
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
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if ((root.left != null && root.left.val >= root.val) || (root.right != null && root.right.val <= root.val))
            return false;
        return isValidBST2(root.left) && isValidBST2(root.right);
    }

    //LeetCode解法1  （递归） 思路：对于每个结点设定最大最小值范围，对于左结点来说，每次需要更新其最大值，对于右结点来说需要每次更新其最小值
    public boolean isValidBST3(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    // 迭代 因为是二叉搜索树，中序遍历的值为从小到大，因此利用中序遍历判断
    //自己写的，缺点：中序遍历中会改变树的结构,且需要额外的列表存放中序遍历
    public boolean isValidBST4(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> inOrder = new ArrayList<>();
        //会改变树的结构
        while (!stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peek().left != null) {
                TreeNode left = stack.peek().left;
                stack.peek().left = null;
                stack.push(left);
            }
            TreeNode node = stack.pop();
            inOrder.add(node.val);
            if (node.right != null) stack.push(node.right);
        }
        for (int i = 0; i < inOrder.size() - 1; i++) {
            if (inOrder.get(i) >= inOrder.get(i + 1)) return false;
        }
        return true;
    }

    //LeetCode解法2   迭代 因为是二叉搜索树，中序遍历的值为从小到大，因此利用中序遍历判断
    public boolean isValidBST5(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

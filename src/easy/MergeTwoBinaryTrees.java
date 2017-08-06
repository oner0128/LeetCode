package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rrr on 2017/8/6.
 * 617. Merge Two Binary Trees
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
    //dfs  26ms  recursion
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);//重新创建新结点
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    //dfs 19 ms recursion
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val = t1.val + t2.val;//更新t1的值
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //dfs 19 ms iterative 思路：将两个根结点利用stack，
    // 在每一步中，一次取出两个结点进行值更新并放入第一个树种，
    // 若stack弹出的两个结点都存在左孩子或右孩子则将其孩子都入栈
    //若第一个结点不存在左孩子，则将第二个结点的左孩子赋给第一个结点，其他孩子的情况类似
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = t1;
        stack.push(t1);
        stack.push(t2);
        while (!stack.isEmpty()) {
            t2 = stack.pop();
            t1 = stack.pop();
            t1.val += t2.val;
            if (t1.left != null&&t2.left!=null) {
                stack.push(t1.left);
                stack.push(t2.left);
            }else if (t1.left==null) t1.left=t2.left;
            if (t1.right != null&&t2.right!=null) {
                stack.push(t1.right);
                stack.push(t2.right);
            }else if (t1.right==null) t1.right=t2.right;
        }
        return root;
    }
    public TreeNode mergeTrees4(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}

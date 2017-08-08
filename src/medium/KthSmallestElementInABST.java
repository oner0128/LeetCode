package medium;

import base.TreeNode;

import java.util.Stack;

/**
 * Created by rrr on 2017/6/20.
 * 230. Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ? k ? BST's total elements.
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?v
 */
public class KthSmallestElementInABST {
    //没思路，参考LeetCode答案
    //binary search (dfs)
    public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if (k <= count) return kthSmallest(root.left, k);
        else if (k > count + 1) return kthSmallest(root.right, k - 1 - count);
        return root.val;
    }

    private int countNode(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }

    //in-order
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        while (root != null) {
            nodes.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode node = nodes.pop();
            k--;
            if (k == 0) return node.val;
            while (node.right != null) {
                nodes.push(node.right);
                node.right=node.right.left;
            }
        }
        return -1;
    }
}

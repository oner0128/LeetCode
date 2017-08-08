package medium;

import base.TreeNode;

/**
 * Created by rrr on 2017/8/7.
 * 114. Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 */
public class FlattenBinaryTreeToLinkedList {
    //dfs   preOrder recuri
    public void flatten(TreeNode root) {
        if (root==null)return;
        flatten(root.left);
        flatten(root.right);
        if (root.right==null)root.right=root.left;
        else if (root.left!=null){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.right=root.left;
            while (left.right!=null)left=left.right;
            left.right=right;
        }
        root.left=null;
    }

    //Leetcode解法 post order traversal
    private TreeNode prev = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

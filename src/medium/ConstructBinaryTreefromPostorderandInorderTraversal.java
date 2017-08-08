package medium;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/4/6.
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPostorderandInorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inMap.get(postorder[postEnd]);
        int numRight = inEnd - inRoot;
        root.left = build(inorder, inStart, inRoot - 1, postorder, postStart, postEnd - numRight - 1, inMap);
        root.right = build(inorder, inRoot + 1, inEnd, postorder, postEnd - numRight, postEnd - 1, inMap);
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int[] post = {1, 3, 5, 4, 2, 9, 8, 7, 6};
        int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        medium.hard.TreeNode root = buildTree(pre, in);
//        inOrder(root);
        TreeNode root3 = buildTree(in,post);
        preOrder(root3);
    }
}

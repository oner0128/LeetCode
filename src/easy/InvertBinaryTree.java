package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rrr on 2017/5/3.
 * 226. Invert Binary Tree
 * Invert a binary tree.
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    //Iterative bfs  0ms
    //time O(n) space O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

    //Recursive 1ms
    //time O(n) space O(n)
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}

package easy;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rrr on 2017/4/29.
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    //递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //迭代 bfs
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return count;
    }

    //迭代 dfs
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> values = new Stack<>();
        int max = 0;
        nodes.push(root);
        values.push(1);
        while (!nodes.isEmpty()) {
            int tmp = values.pop();
            TreeNode node = nodes.pop();
            max = Math.max(tmp, max);
            if (node.left != null) {
                nodes.push(node.left);
                values.push(tmp + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                values.push(tmp + 1);
            }
        }
        return max;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

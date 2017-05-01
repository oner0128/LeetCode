package easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rrr on 2017/5/1.
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    //递归
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        return (left==0||right==0)?left+right+1:Math.min(left,right)+1;
    }
    //LeetCode解法 递归
    public static int minDepth4(TreeNode root) {
        if (root == null)	return 0;
        if (root.left == null)	return minDepth4(root.right) + 1;
        if (root.right == null) return minDepth4(root.left) + 1;
        return Math.min(minDepth4(root.left),minDepth4(root.right)) + 1;
    }

    //迭代 dfs
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> values = new Stack<>();
        int min = Integer.MAX_VALUE;
        nodes.push(root);
        values.push(1);
        while (!nodes.isEmpty()) {
            int tmp = values.pop();
            TreeNode node = nodes.pop();
            if (node.left == null && node.right == null) min = Math.min(min, tmp);
            if (node.left != null) {
                nodes.push(node.left);
                values.push(tmp + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                values.push(tmp + 1);
            }
        }
        return min;
    }

    //迭代 bfs
    public int minDepth3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodes = new LinkedList<>();
        int minDepth = 1;
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node.left == null && node.right == null) return minDepth;
                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
            }
            minDepth++;
        }
        return minDepth;
    }
}

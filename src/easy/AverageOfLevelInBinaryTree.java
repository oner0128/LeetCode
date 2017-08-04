package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rrr on 2017/8/4.
 * 637. Average of Levels in Binary Tree
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * <p>
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }
    //Leetcode dfs
    //思路，在深度遍历过程中将每层的数按等级相加，最后在除以每层的结点个数，和记录在answer中，每层结点数记录在counter中
    public List<Double> averageOfLevels2(TreeNode root) {
        // list answer for sum all value in same level
        List<Double> answer = new ArrayList<Double>();

        // list counter for count number of node in same level
        List<Integer> counter = new ArrayList<Integer>();

        // using dfs to sum all value in same level and count number of node in same level
        dfs(0, root, answer, counter);

        // answer will be answer[level] / counter[level]
        for (int level = 0; level < answer.size(); level++) {
            answer.set(level, answer.get(level) / counter.get(level));
        }
        return answer;
    }

    public void dfs(int level, TreeNode node, List<Double> answer, List<Integer> counter) {
        if (node == null) {
            return;
        }

        if (answer.size() <= level) {
            answer.add(0.0);
            counter.add(0);
        }

        answer.set(level, answer.get(level) + node.val);
        counter.set(level, counter.get(level) + 1);

        // go left node and right node
        dfs(level + 1, node.left, answer, counter);
        dfs(level + 1, node.right, answer, counter);
    }
}

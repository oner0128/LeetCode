package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rrr on 2017/8/4.
 * 107. Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {
    //思路：跟按层遍历二叉树思路一样，分为bfs和dfs，但是此题要求先输出树的底部，
    // 技巧在于在res.add（0，list）总增加在第一个即可
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, root, res);
        return res;
    }

    private void dfs(int level, TreeNode root, List<List<Integer>> res) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(0, new LinkedList<>());//层数为倒序
        }
        dfs(level + 1, root.left, res);
        dfs(level + 1, root.right, res);
        res.get(res.size()-level-1).add(root.val);//层数为倒序
    }
}

package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rrr on 2017/8/8.
 * 199. Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * You should return [1, 3, 4].
 * <p>
 * Credits:
 */
public class BinaryTreeRightSideView {
    //dfs
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        dfs(root, listList, 0);
        List<Integer> answer = new ArrayList<>();
        for (List<Integer> list : listList)
            answer.add(list.get(list.size() - 1));
        return answer;
    }

    private void dfs(TreeNode root, List<List<Integer>> listList, int level) {
        if (root == null) return;
        if (level >= listList.size()) listList.add(new ArrayList<>());
        listList.get(level).add(root.val);
        dfs(root.left, listList, level + 1);
        dfs(root.right, listList, level + 1);
    }

    //bfs
    public List<Integer> rightSideView2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            while (size-->0){
                TreeNode node=queue.poll();
                if (size==0)answer.add(node.val);
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
        }
        return answer;
    }
}

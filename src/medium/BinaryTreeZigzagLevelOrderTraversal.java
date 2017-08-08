package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rrr on 2017/8/6.
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]
 思路：跟按层遍历思路一样，有dfs和bfs解法
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    //dfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>results=new LinkedList<>();
        zigZagTraversal(root,results,0);
        return results;
    }

    private void zigZagTraversal(TreeNode root, List<List<Integer>> results, int level) {
        if (root==null)return;
        if (level>=results.size())results.add(new LinkedList<>());
        List<Integer>cur=results.get(level);
        if (level%2==0)cur.add(root.val);
        else cur.add(0,root.val);
        zigZagTraversal(root.left,results,level+1);
        zigZagTraversal(root.right,results,level+1);
    }

    //bfs queue 需要一个标记之字是正向还是反向
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>>results=new LinkedList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        if (root!=null)queue.offer(root);
        boolean isZigZag=false;
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer>list=new ArrayList<>();
            while (size-->0){
                TreeNode node=queue.poll();
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
                if (isZigZag)list.add(0,node.val);
                else list.add(node.val);
            }
            isZigZag=!isZigZag;//取反
            results.add(list);
        }
        return results;
    }
}

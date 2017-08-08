package medium;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rrr on 2017/5/10.
 * 144.Binary Tree Preorder Traversal
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [1,2,3].
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return res;
    }
    //leetcode 大神解法 只保存右子树
    /*Note that in this solution only right children are stored to stack.*/
    public List<Integer> preorderTraversal2(TreeNode node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }
    public List<Integer> preorderTraversal3(TreeNode node) {
        List<Integer> pre = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(node != null||!stack.isEmpty()) {
            if (node!=null){
                pre.add(node.val);
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();

            }
        }
        return pre;
    }
}

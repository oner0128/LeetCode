package hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rrr on 2017/5/10.
 * 145. Binary Tree Postorder Traversal
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * return [3,2,1].
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastNode = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                if (node.right == null || node.right == lastNode) {//无右子树或右子树已经遍历
                    cur=stack.pop();
                    post.add(cur.val);
                    lastNode = cur;
                    cur = null;
                } else {//存在右子树且右子树未遍历
                    cur=node.right;
                }
            }
        }
        return post;
    }
}

package easy;

import java.util.*;

/**
 * Created by rrr on 2017/8/5.
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    //leetCode iterative  bfs
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        //因为是镜像求解，所以在队列中放两个root
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t1=queue.poll();
            TreeNode t2=queue.poll();
            if (t1==null&&t2==null)continue;
            if (t1==null||t2==null)return false;
            if (t1.val!=t2.val)return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    //leetCode recursive  dfs
    public boolean isSymmetric2(TreeNode root) {
        return root==null||isSymmetricHelper(root.left,root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left==null||right==null)return left==right;
        if (left.val!=right.val)return false;
        return isSymmetricHelper(left.left,right.right)&&isSymmetricHelper(left.right,right.left);
        //关键点，例如在深度为3时，需要比较的是左结点的左孩子是否等于右结点的右孩子，和左结点的右孩子是否等于右结点的左孩子
    }
}

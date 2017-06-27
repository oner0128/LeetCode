package medium;

/**
 * Created by rrr on 2017/6/20.
 * 222. Count Complete Tree Nodes
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last,
 * is completely filled, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
    //没思路，不知道如何处理最后一层的结点数
    //LeetCode解法
    public int countNodes(TreeNode root) {
        if (root==null)return 0;
        int leftHeight = height(root.left);
        int rightHeight= height(root.right);
        if (leftHeight==rightHeight)return (1<<leftHeight)+countNodes(root.right);//完全左子树 ，最后一层的最后一个结点在右子树部分
        /*1(根节点) + (1<<lh)-1(完全左子树) + # of rightNode */
        else return (1<<rightHeight)+countNodes(root.left);//完全右子树，最后一层的最后一个结点在左子树部分
        /*1(根节点) + (1<<rh)-1(完全右子树) + # of leftNode*/
    }

    private int height(TreeNode root) {
        int k = 0;
        while (root != null) {
            k++;
            root = root.left;
        }
        return k;
    }
    public int countNodes2(TreeNode root) {
        if (root==null)return 0;
        int leftHeight = leftHeight(root);
        int rightHeight= rightHeight(root);
        if (leftHeight==rightHeight)return (1<<leftHeight)-1;//满二叉树  /*(1<<lh)-1 */
        else return 1+ countNodes2(root.left)+countNodes2(root.right);//最后一层的最后一个结点在可能在左子树部分，也可能在右子树部分
    }

    private int rightHeight(TreeNode root) {
        int k = 0;
        while (root != null) {
            k++;
            root = root.left;
        }
        return k;
    }

    private int leftHeight(TreeNode root) {
        int k = 0;
        while (root != null) {
            k++;
            root = root.right;
        }
        return k;
    }

}

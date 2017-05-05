/**
 * Created by rrr on 2017/5/5.
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode left = helperLeft(pRootOfTree.left);
        TreeNode right = helperRight(pRootOfTree.right);
        if (left != null) {left.right = pRootOfTree;
            pRootOfTree.left=left;}
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right=right;}
        while (pRootOfTree.left!=null)pRootOfTree=pRootOfTree.left;
        return pRootOfTree;
    }

    private static TreeNode helperLeft(TreeNode root) {
        if (root == null) return null;
        TreeNode left = helperLeft(root.left);
        TreeNode right = helperLeft(root.right);
        if (left != null) {left.right = root;
        }
        if (right != null) {
            right.left = root;root.right=right;
            return right;
        } else return root;
    }
    private static TreeNode helperRight(TreeNode root) {
        if (root == null) return null;
        TreeNode right = helperRight(root.right);
        TreeNode left = helperRight(root.left);
        if (right != null) {right.left = root;
            }
        if (left != null) {
            left.right = root; root.left=left;
            return left;
        } else return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);root.left.left.right = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);root.right.right = new TreeNode(9);
        Convert(root);
    }
}

/**
 * Created by rrr on 2017/6/29.
 */
public class BSTKthNode {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return pRoot;
        int leftNums = countNodes(pRoot.left);
        if (leftNums+1 > k) return KthNode(pRoot.left, k);//the node nums =(left childs +rood) > k ,so kth in root.left
        else if (leftNums+1 < k) return KthNode(pRoot.right, k - leftNums - 1);//the node nums =(left childs +rood) < k ,so kth in root.right
        else return pRoot;//the node nums =(left childs +rood) == k ,so kth is root
    }

    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/4/6.
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *Given preorder and inorder traversal of a tree, construct the binary tree.
 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    //自己完全想不来
    //LeetCode解法
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, inorder.length, 0);
    }

    private static TreeNode dfs(int[] preorder, int[] inorder, int start, int end, int preStart) {
        if (start > end||preStart>=inorder.length) return null;
        int index;
        TreeNode root = new TreeNode(preorder[preStart]);
        index = start;
        while (preorder[preStart] != inorder[index]&&index<=end) index++;
        root.left = dfs(preorder, inorder, start, index - 1, preStart + 1);
        root.right = dfs(preorder, inorder, index + 1, end, index +preStart+1-start);//不明白root.right的preStart为何是index +preStart+1-start
        return root;
    }

    //LeetCode解法2
    //比解法1好理解
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return build2(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build2(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
        if(preLow>preHigh || inLow>inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i]==root.val){ inorderRoot=i; break; }
        }

        int leftTreeLen = inorderRoot-inLow;
        root.left = build2(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
        root.right = build2(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);
        return root;
    }
//  Nice solution! One improvement: remember to use HashMap to cache the inorder[] position. This can reduce your solution from 20ms to 5ms.
// Here is the my Java solution:
//LeetCode解法3
//在解法2上的优化，利用HashMap快速定位
public static TreeNode buildTree3(int[] preorder, int[] inorder) {
    Map<Integer,Integer> map=new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i],i);
    }
    return build3(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1,map);
}

    public static TreeNode build3(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh, Map<Integer, Integer> map){
        if (preLow>preHigh||inLow>inHigh)return null;
        TreeNode root=new TreeNode(preorder[preLow]);
        int inRoot=map.get(preorder[preLow]);
        int numLeft=inRoot-inLow;
        root.left=build3(preorder,preLow+1,preLow+numLeft,inorder,inLow,inRoot-1,map);
        root.right=build3(preorder,preLow+numLeft+1,preHigh,inorder,inRoot+1,inHigh,map);
        return root;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void main(String[] args) {
        int[] pre = {6, 2, 1, 4, 3, 5, 7, 8, 9};
        int[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode root = buildTree(pre, in);
        inOrder(root);
        TreeNode root3 = buildTree3(pre, in);
        System.out.println();
        inOrder(root3);
    }
}


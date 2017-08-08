package medium;

import base.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rrr on 2017/8/4.
 * 95. Unique Binary Search Trees II
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    //LeetCode解法
    public List<TreeNode> generateTrees(int n) {
        if (n==0)return new LinkedList<>();
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode>left,right;
        for (int i = start; i <= end; i++) {
            left=genTrees(start,i-1);
            right=genTrees(i+1,end);
            for (TreeNode leftNode:left){
                for (TreeNode rightNode:right){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

package easy;

import java.util.Stack;

/**
 * Created by rrr on 2017/5/10.
 * 100. Same Tree
 * Given two binary trees, write a function to check if they are equal or not.
 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    //递归dfs
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null||q==null)return (p==null&&q==null)?true:false;
        boolean left=isSameTree(p.left,q.left);
        boolean right=isSameTree(p.right,q.right);
        boolean value=p.val==q.val;
        return left&&right&&value;
    }
    //leetCode大神
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p==null||q==null)return (p==null&&q==null)?true:false;
        return p.val==q.val&&isSameTree2(p.left,q.left)&&isSameTree2(p.right,q.right);
    }
    //leetCode大神 迭代 使用两个栈
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p==null||q==null)return (p==null&&q==null)?true:false;
        Stack<TreeNode>stackp=new Stack<>();
        Stack<TreeNode>stackq=new Stack<>();
        stackp.push(p);stackq.push(q);
        while (!stackp.isEmpty()&&!stackq.isEmpty()){
            TreeNode nodep=stackp.pop();
            TreeNode nodeq=stackq.pop();
            if (nodep.val!=nodeq.val)return false;
            if (nodep.left!=null)stackp.push(nodep.left);
            if (nodeq.left!=null)stackq.push(nodeq.left);
            if (stackp.size()!=stackq.size())return false;
            if (nodep.right!=null)stackp.push(nodep.right);
            if (nodeq.right!=null)stackq.push(nodeq.right);
            if (stackp.size()!=stackq.size())return false;
        }
        return stackp.size()==stackq.size();
    }
}

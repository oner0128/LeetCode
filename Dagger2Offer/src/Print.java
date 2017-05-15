import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by rrr on 2017/5/14.
 */
public class Print {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        if (pRoot==null)return res;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(pRoot);
        int leftToRight=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer>list=new ArrayList<>();
            while (size-->0){
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
            if (leftToRight%2==1)Collections.reverse(list);
            res.add(list);leftToRight++;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        root.left=new TreeNode(6);
        root.right=new TreeNode(10);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(7);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(11);
        System.out.println(Print(root));
    }
}

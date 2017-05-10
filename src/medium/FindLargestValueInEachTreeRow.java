package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rrr on 2017/5/10.
 */
public class FindLargestValueInEachTreeRow {
    //思路:树的按层遍历,然后记录每层的最大值即可
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>maxRow=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        if (root!=null)queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            int max=queue.peek().val;
            while (size-->0){
                TreeNode node=queue.poll();
                max=Math.max(max,node.val);
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
            maxRow.add(max);
        }
        return maxRow;
    }
    //LeetCode解法 9ms JAVA DFS solution
    //Just a simple pre-order traverse idea. Use depth to expand result list size and put the max value in the appropriate position.
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
        //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}

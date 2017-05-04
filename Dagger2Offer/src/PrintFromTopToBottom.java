import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rrr on 2017/5/4.
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null)return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer>res=new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
                TreeNode node=queue.poll();
                res.add(node.val);
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
            }
        }
        return res;
    }
}

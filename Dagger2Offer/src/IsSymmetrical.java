import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rrr on 2017/5/14.
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)return true;
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer>list2=new ArrayList<Integer>();
        //root left right
        TreeNode node=pRoot;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                list1.add(node.val);
                stack.push(node);
                node=node.left;
            }
            TreeNode tmp=stack.pop();
            node=tmp.right;
            if(node==null)list1.add(null);
        }
        //root right left
        node=pRoot;
        while(node!=null||!stack.isEmpty()){
            while(node!=null){
                list2.add(node.val);
                stack.push(node);
                node=node.right;
            }
            TreeNode tmp=stack.pop();
            node=tmp.left;if(node==null)list2.add(null);
        }
        for(int i=0;i<list1.size();i++)
            if(list1.get(i)!=list2.get(i))return false;
        return true;
    }
    boolean isSymmetrical2(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1==null&&pRoot2==null)return true;
        if (pRoot1==null||pRoot2==null)return false;
        if (pRoot1.val!=pRoot2.val)return false;
        return isSymmetrical(pRoot1.left,pRoot2.right)&&isSymmetrical(pRoot1.right,pRoot2.left);
    }
}

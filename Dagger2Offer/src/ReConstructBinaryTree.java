import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/5/3.
 */
public class ReConstructBinaryTree {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0||pre==null)return null;
        return helper(pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode helper( int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart>preEnd||inStart>inEnd)return null;
        int rootVal=pre[preStart];
        int rootIndex=0;
        TreeNode root=new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i]==rootVal){rootIndex=i;break;}
        }
        int numsLeft=rootIndex-inStart;//关键
        TreeNode left=helper(pre,preStart+1,preStart+numsLeft,in,inStart,rootIndex-1);
        TreeNode right=helper(pre,preStart+numsLeft+1,preEnd,in,rootIndex+1,inEnd);
        root.left=left;
        root.right=right;
        return root;
    }
    public static TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
        if (pre.length==0||pre==null)return null;
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < in.length; i++)map.put(in[i],i);
        return helper2(map,pre,0,pre.length-1,in,0,in.length-1);
    }

    private static TreeNode helper2(Map<Integer, Integer> map, int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart>preEnd||inStart>inEnd)return null;
        int rootVal=pre[preStart];
        int rootIndex=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);
        int numsLeft=rootIndex-inStart;//关键
        TreeNode left=helper2(map,pre,preStart+1,preStart+numsLeft,in,inStart,rootIndex-1);
        TreeNode right=helper2(map,pre,preStart+numsLeft+1,preEnd,in,rootIndex+1,inEnd);
        root.left=left;
        root.right=right;
        return root;
    }

    public static void main(String[] args) {
        int[]pre={1,2,4,7,3,5,6,8};
        int[]in={4,7,2,1,5,3,8,6};
        reConstructBinaryTree(pre,in);
    }
}

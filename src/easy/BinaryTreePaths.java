package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrr on 2017/8/4.
 * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result=new ArrayList<>();
        if(root!=null)dfs(root,"",result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left==null&&root.right==null)result.add(path+root.val);
        if (root.left!=null)dfs(root.left,path+root.val+"->",result);
        if (root.right!=null)dfs(root.right,path+root.val+"->",result);
    }
}

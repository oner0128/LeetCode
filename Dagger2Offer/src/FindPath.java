import java.util.ArrayList;

/**
 * Created by rrr on 2017/5/5.
 * 题目描述
 * 输入一颗二叉树和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), root, target);
        return res;
    }

    private static void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list, TreeNode root, int target) {
        if (root == null) return;
        if (root.left == null && root.right == null && target == root.val) {
            list.add(root.val);
            res.add(new ArrayList<>(list));list.remove(list.size() - 1);
        } else {
            list.add(root.val);
            helper(res, list, root.left, target - root.val);
            helper(res, list, root.right, target - root.val);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        TreeNode d=root;
        d.left=new TreeNode(5);
        d.right=new TreeNode(12);
        d.left.left=new TreeNode(4);
        d.left.right=new TreeNode(7);
        System.out.println(FindPath(root,22));
    }
}

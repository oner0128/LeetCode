package easy;

/**
 * Created by rrr on 2017/6/17.
 * 108. Convert Sorted Array to Binary Search Tree
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums==null||nums.length==0)return null;
        return ToBST(nums,0,nums.length-1);
    }

    private TreeNode ToBST(int[] nums, int start, int end){
        if (start>end)return null;
        int mid=(start+end+1)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=ToBST(nums,start,mid-1);
        root.right=ToBST(nums,mid+1,end);
        return root;
    }
}

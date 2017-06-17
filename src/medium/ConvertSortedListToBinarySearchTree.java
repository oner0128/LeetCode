package medium;

/**
 * Created by rrr on 2017/6/17.
 * 109. Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
    //LeetCode解法
    //思路：先找到链表的中间结点
    // 然后将该结点作为根节点
    //再递归的构造该结点的左右子树
    // 因为都是将中间结点作为根节点，因此树是平衡的
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null)return null;
        return ToBST(head,null);
    }

    private TreeNode ToBST(ListNode head, ListNode tail) {
        if (head==null||head==tail)return null;
        ListNode fast=head,slow=head;
        while (fast!=tail&&fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root=new TreeNode(slow.val);
        root.left=ToBST(head,slow);//左子树为head到中间结点的前一个结点
        root.right=ToBST(slow.next,tail);//右子树为solw结点的下一个结点到tail结点,不是fast结点
        return root;
    }
}

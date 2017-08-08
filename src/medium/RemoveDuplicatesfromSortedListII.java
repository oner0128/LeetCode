package medium;

import base.ListNode;

/**
 * Created by rrr on 2017/6/17.
 * 82. Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesfromSortedListII {
    //思路：跟一解法不同之处在于当有重复结点时不保留该结点，因此需要一个前置结点
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        ListNode prehead=new ListNode(0);
        prehead.next=head;
        ListNode pre=prehead;
        while (head!=null){
            ListNode cur=head;
            while (cur.next!=null&&cur.val==cur.next.val)cur=cur.next;
            if (head==cur){
                pre=head;
                head=head.next;
            }else {
                pre.next=cur.next;
                head=cur.next;
            }
        }
        return prehead.next;
    }
}

package easy;

/**
 * Created by rrr on 2017/6/5.
 * 83. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)return null;
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        while (head!=null){
            ListNode cur=head;
            while (cur.next!=null&&cur.val!=cur.next.val)cur=cur.next;
            head.next=cur.next;
            head=head.next;
        }
        return preHead.next;
    }
}

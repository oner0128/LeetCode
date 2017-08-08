package medium;

import base.ListNode;

/**
 * Created by rrr on 2017/5/18.
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)return head;
        ListNode pHead=new ListNode(0);
        pHead.next=head;
        ListNode p1=pHead;
        ListNode p2=head;
        while(--n>0)p2=p2.next;
        while(p2!=null&&p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }
        p1.next=p1.next.next;
        return pHead.next;
    }
    //LeetCode
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null)return null;
        ListNode p1=head;
        ListNode p2=head;
        while(n-->0)p2=p2.next;
        if (p2==null)return head.next;//head need to be removed
        while(p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }
        p1.next=p1.next.next;
        return head;
    }
}

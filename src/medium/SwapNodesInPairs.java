package medium;

import base.ListNode;

/**
 * Created by rrr on 2017/6/4.
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode cur = head;
        ListNode pre = prehead;
        while (cur != null && cur.next != null) {
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=cur;
            pre.next=next;
            pre=next;
            cur=cur.next;
        }
        return prehead.next;
    }
    public ListNode swapPairs2(ListNode head) {
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode cur = head;
        ListNode pre = prehead;
        while (cur != null && cur.next != null) {
            pre.next=cur.next;
            cur.next=cur.next.next;
            pre.next.next=cur;
            pre=cur;
            cur=cur.next;
        }
        return prehead.next;
    }
}

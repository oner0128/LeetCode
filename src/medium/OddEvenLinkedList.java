package medium;

import base.ListNode;

/**
 * Created by rrr on 2017/6/5.
 * 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on .
 */
public class OddEvenLinkedList {
    //思路：利用i计算当前奇偶，保持两个指针odd和even，最后将两条链表相连
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode odd=head;
        ListNode evenhead=head.next;
        ListNode even=evenhead;
        ListNode cur=even.next;
        for (int i = 3;cur!=null; i++) {
            if (i%2==1){odd.next=cur;odd=odd.next;}
            else {even.next=cur;even=even.next;}
            cur=cur.next;
        }
        odd.next=evenhead;
        even.next=null;//当结点数为奇数时，偶链表最后一个结点的下一个结点是一个奇结点，需要至空
        return head;
    }
    //LeetCode解法
    public ListNode oddEvenList2(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}

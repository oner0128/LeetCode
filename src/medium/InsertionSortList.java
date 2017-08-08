package medium;

import base.ListNode;

/**
 * Created by rrr on 2017/6/7.
 * 147. Insertion Sort List
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    //思路：在原链表前加入一个头结点用于查找每次需要插入的位置
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode cur = head.next;//0->4->5->1->3->2
        while (cur != null) {
            ListNode pre = prehead;
            while (pre != null && pre.next.val < cur.val) pre = pre.next;
            if (pre.next == cur) {
                cur = cur.next;
            } else {
                ListNode next = cur.next;
                cur.next = pre.next;
                ListNode preNext = pre.next;
                pre.next = cur;
                while (preNext.next != cur) preNext = preNext.next;
                preNext.next = next;
                cur = next;
            }
        }
        return prehead.next;
    }
    //LeetCode解法
    //思路：与自己的思路不同之处在于不需要将新建的头结点链接到原链表中，新链表的头结点用于查找插入位置然后链接即可
    //即保持两个指针，一个是新链表的头结点，一个是原链表的当前结点
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) return head;
        ListNode prehead = new ListNode(0);
//        prehead.next = head;不再需要
        ListNode cur = head;//4->5->1->3->2
        ListNode pre = null;
        while (cur != null) {
            pre = prehead;
            while (pre .next!= null && pre.next.val < cur.val) pre = pre.next;
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return prehead.next;
    }
}

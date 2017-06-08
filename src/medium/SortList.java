package medium;

import java.util.List;

/**
 * Created by rrr on 2017/6/8.
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    //归并排序：先需要找到中间结点，之后再归并
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
//        ListNode prehead=new ListNode(0);
        ListNode slow = head, fast = head;
        while (fast .next!= null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        ListNode middle=slow.next;//保存后半部分链表
        slow.next=null;//将前后链表分离
        fast = sortList(fast);
        middle = sortList(middle);
        return merge(fast, middle);
    }
    //16 ms
    private static ListNode merge(ListNode fast, ListNode slow) {
        ListNode preHead = new ListNode(0);
        ListNode cur=preHead;
        while (fast != null || slow != null) {
            Integer fastValue = fast != null ? fast.val : null;
            Integer slowValue = slow != null ? slow.val : null;
            cur.next = fastValue == null ? slow : (slow == null ? fast : (fastValue > slowValue ? slow : fast));
            cur = cur.next;
            fast = cur == fast ? fast.next : fast;
            slow = cur == slow ? slow.next : slow;
        }
        return preHead.next;
    }
    //LeetCode解法
    //在上一个merge中加入太多判断条件导致耗时较多
    //10ms
    ListNode merge2(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(2);
        node.next=new ListNode(1);
        node=sortList(node);
    }
}

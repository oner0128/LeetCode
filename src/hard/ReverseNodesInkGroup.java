package hard;

import java.nio.file.LinkOption;

/**
 * Created by rrr on 2017/6/17.
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInkGroup {
    //思路：先求出链表长度，若小于k，则返回head
    // 当len大于等于k时，以k为单位翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len < k) return head;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode pre = prehead;
        cur = head;
        while (len >= k && cur != null) {
            int count = k;
            while (--count > 0) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            len -= k;
            pre = cur;
            cur = cur.next;
        }
        return prehead.next;
    }
}

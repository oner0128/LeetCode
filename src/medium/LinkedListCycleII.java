package medium;

/**
 * Created by rrr on 2017/6/5.
 * 142. Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;//no cycle
        //我们假设slow走了n步，而fast走了2n步.在环的某个点相遇（假设点D).
        // 那么，想一下.如果让fast不动,让slow在走n步,slow是不是刚好又回到了这个相遇点（D）？
        // (因为fast走了2n步到达这个地方).那么此时，如果让fast也从链表的开头走，走n步.
        // 那么fast和slow必定会在D相遇.但是，这之前，它们就会提前相遇，而相遇点就是环入口！
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

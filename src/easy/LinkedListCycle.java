package easy;

/**
 * Created by rrr on 2017/6/5.
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle {
    //思路：利用快慢指针，若有环它们会相交于同一点
    public boolean hasCycle(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow)return true;
        }
        return false;
    }
}

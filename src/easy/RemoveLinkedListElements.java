package easy;

/**
 * Created by rrr on 2017/5/3.
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    //1ms
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)return null;
        ListNode res = head;
        while (res.next != null) {
            if (res.next.val == val) res.next = res.next.next;
            else res = res.next;
        }
        return head.val == val ? head.next : head;
    }
    //递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

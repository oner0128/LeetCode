/**
 * Created by rrr on 2017/5/10.
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    //删除重复结点,重复的结点不保留
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode result = new ListNode(0);
        ListNode pre=result;
        pre.next = pHead;
        while (pHead != null) {
            while (pHead.next != null && pHead.val == pHead.next.val) pHead = pHead.next;
            if (pre.next == pHead) {
                pre = pHead;
                pHead = pHead.next;
            } else {
                pre.next = pHead.next;
                pHead = pHead.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node = root;
        node.next = new ListNode(2);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(3);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(4);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        ListNode res=deleteDuplication(root);
    }

    //删除重复结点,但是保留一个
    public ListNode helper(ListNode pHead, boolean cur) {
        if (pHead == null || pHead.next == null) return null;
        helper(pHead.next, cur);
        if (pHead.val == pHead.next.val) pHead.next = pHead.next.next;
        return pHead;
    }
}

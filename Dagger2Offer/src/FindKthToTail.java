/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null||k==0) return null;
        ListNode first = head;
        ListNode second ;
        for (int i = 0; i < k - 1; i++) {
            if (first.next!=null)first=first.next;
            else return null;
        }
        second=head;
        while (first.next!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        while (--k>0) pre=pre.next;
        pre.next=null;
        return pre;
    }
}

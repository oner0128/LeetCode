package medium;

import java.util.List;

/**
 * Created by rrr on 2017/6/5.
 * 61. Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
public class RotateList {
    //思路：因未知链表长度因此需先遍历一次找出链表长度，然后再找到需要右移的链表结点
    ////20ms beat 23%
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        k %= len;
        if (k == 0) return head;
        cur = head;
        int moveLen = len - k;
        while (--moveLen > 0) cur = cur.next;
        ListNode right=cur.next;
        while (right.next!=null)right=right.next;
        right.next=head;
        right=cur.next;
        cur.next=null;
        return right;
    }
    //思路：根据上一个思路改进，右移链表最终需要把尾结点next至为head，
    // 因此利用第一次遍历计算链表长度时保存尾结点，减少在右移时重新遍历一次链表
    //17ms beat 57% O(n)
    //思考：能否不计算链表长度而完成右移，即当遍历到尾结点时将尾结点next至为head形成环，
    //第二次遍历时右移k-1个结点node，node.next=null,return node;
    //答案是不能，因为如果k远远大于链表长度，则第二次遍历时会在环中重复多次，时间复杂度为O(n+k)
    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode cur = head;
        int len = 1;
        while (cur.next!= null) {
            len++;
            cur = cur.next;
        }
        ListNode rear = cur;//保存尾结点
        k %= len;
        if (k == 0) return head;
        cur = head;
        int moveLen = len - k;
        while (--moveLen > 0) cur = cur.next;
        rear.next=head;
        head=cur.next;
        cur.next=null;
        return head;
    }
}

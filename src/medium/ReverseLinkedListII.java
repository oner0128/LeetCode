package medium;

import java.util.List;

/**
 * Created by rrr on 2017/5/16.
 * 92. Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedListII {
    //LeetCode解法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //昨晚已有思路
        if(head==null)return head;
        n-=m;
        ListNode pHead=new ListNode(0);
        pHead.next=head;
        ListNode pre=pHead;
        while (--m>0)pre=pre.next;//保存反转开始结点的前一个结点
        ListNode pStart=pre.next;//开始反转的第一个结点
        //Reverse ListNode
        while (n-->0){
            ListNode next=pStart.next;
            pStart.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return pHead.next;
    }
}

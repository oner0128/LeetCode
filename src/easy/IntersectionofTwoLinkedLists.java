package easy;

/**
 * Created by rrr on 2017/5/18.
 * 160. Intersection of Two Linked Lists
 * Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.
 */
public class IntersectionofTwoLinkedLists {
    //先求两条链表的长度，然后将p1,p2对齐
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode p1=headA;
        ListNode p2=headB;
        int p1Len=0,p2Len=0;
        while(p1!=null){p1Len++;p1=p1.next;}
        while(p2!=null){p2Len++;p2=p2.next;}
        int m=p1Len-p2Len;
        p1=headA;p2=headB;
        if(m>0)while(m-->0)p1=p1.next;
        else while(m++<0)p2=p2.next;
        while(p1!=null&&p2!=null){
            if(p1.val==p2.val)return p1;
            p1=p1.next;
            p2=p2.next;
        }
        return null;
    }
    //leetCode解法
    //不用求长度，迭代两次，第一次迭代能够抵消两条链表长度的不同，第二遍迭代寻找相同点入口
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode p1=headA;
        ListNode p2=headB;
       while (p1!=p2){//if a & b have different len, Our operations in first iteration will help us counteract the difference.
           // then we will stop the loop after second iteration
           p1=p1==null?headB:p1.next;//for the end of first iteration, we just reset the pointer to the head of another linkedlist
           p2=p2==null?headA:p2.next;
       }
        return p1;
    }
}

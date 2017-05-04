package medium;

/**
 * Created by rrr on 2017/5/3.
 * 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    //62ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        ListNode root=new ListNode(0);int carry=0;
        ListNode res=root;
        while (l1!=null||l2!=null||carry==1){
            int one=l1==null?0:l1.val;
            int two=l2==null?0:l2.val;
            int sum=(one+two+carry);
            carry=sum/10;
            root=root.next=new ListNode(sum%10);
            l1=l1==null?null:l1.next;l2=l2==null?null:l2.next;;
        }
        if (carry==1)root.next=new ListNode(1);
        return res.next;
    }
    //LeetCode解法 55 ms
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1==null||l2==null)return l1==null?l2:l1;
        ListNode head=new ListNode(0);int sum=0;
        ListNode d=head;
        while (l1!=null||l2!=null||sum!=0){
            int one=l1==null?0:l1.val;
            int two=l2==null?0:l2.val;
            sum=one+two+sum;
            d=d.next=new ListNode(sum%10);
            sum/=10;
            l1=l1==null?null:l1.next;l2=l2==null?null:l2.next;;
        }
        return head.next;
    }
}
class ListNode {
    int val;
     ListNode next;
      ListNode(int x) { val = x; }
}

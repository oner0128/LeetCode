package medium;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by rrr on 2017/5/3.
 * 445. Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 */
public class AddTwoNumbersII {
    //89 ms
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val==0||l2.val==0)return l1.val==0?l2:l1;
        Stack<Integer>stack1=new Stack<>();Stack<Integer>stack2=new Stack<>();
        Stack<Integer>res=new Stack<>();
        while (l1!=null||l2!=null){
            if (l1!=null)stack1.push(l1.val);
            if (l2!=null)stack2.push(l2.val);
            l1=l1==null?null:l1.next;l2=l2==null?null:l2.next;;
        }
        int sum=0;
        while (!stack1.isEmpty()||!stack2.isEmpty()||sum!=0){
            int one=stack1.isEmpty()?0:stack1.pop();
            int two=stack2.isEmpty()?0:stack2.pop();
            sum=one+two+sum;
            res.push(sum%10);
            sum/=10;
        }
        ListNode head=new ListNode(0);
        ListNode d=head;
        while (!res.isEmpty()){
            d=d.next=new ListNode(res.pop());
        }
        return head.next;
    }
    //81 ms
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1.val==0||l2.val==0)return l1.val==0?l2:l1;
        Stack<Integer>stack1=new Stack<>();Stack<Integer>stack2=new Stack<>();
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int sum=0;
        ListNode head=null;
        while (!stack1.empty()||!stack2.empty()||sum!=0){
            int one=stack1.empty()?0:stack1.pop();
            int two=stack2.empty()?0:stack2.pop();
            sum=one+two+sum;
            ListNode node=new ListNode(sum%10);
            node.next=head;
            head=node;
            sum/=10;
        }
        return head;
    }
    //LeetCode  78 ms
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {

        HashMap<Integer, Integer> hm1 = new HashMap<>(); //Store the 'index' and the value of List1
        HashMap<Integer, Integer> hm2 = new HashMap<>(); //Store the 'index' and the value of List2
        int i = 1, j = 1;

        while(l1 != null){
            hm1.put(i, l1.val);
            l1 = l1.next;
            i++;
        }
        while(l2 != null){
            hm2.put(j, l2.val);
            l2 = l2.next;
            j++;
        }

        int carry = 0;
        i--; j--;
        ListNode head = null;

        //Create new nodes to the front of a new LinkedList
        while(i > 0 || j > 0 || carry > 0){

            int a = i > 0 ? hm1.get(i) : 0;
            int b = j > 0 ? hm2.get(j) : 0;
            int res = (a + b + carry) % 10;

            ListNode newNode = new ListNode(res);
            newNode.next = head;
            head = newNode;

            carry = (a + b + carry) / 10;
            i--; j--;
        }
        return head;
    }
}

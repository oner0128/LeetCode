package easy;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 * Created by rrr on 2017/5/3.
 * 206. Reverse Linked List
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {
    //LeetCode Recursive
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    //LeetCode iterative
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    //iterative 3 ms
    public ListNode reverseList3(ListNode head) {
        if (head == null) return null;
        Stack<Integer>stack=new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        ListNode res=head;
        while (!stack.empty()){
            head=new ListNode(stack.pop());
            head=head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode d=root;
        for (int i = 2; i < 3; i++) {
            d.next=new ListNode(i);
            d=d.next;
        }
        reverseList2(root);
    }
}

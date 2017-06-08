package easy;

/**
 * Created by rrr on 2017/6/7.
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    //LeetCode解法
    //思路：1.利用快慢指针找到链表的中间结点middle
    // 2.反转后一半结点
    // 3.两个链表遍历进行比较
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        //find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
//        if (fast != null)//odd number,the middle node is not judged,like  121 is palindrome
//            slow = slow.next;
        //reverse half link
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        //judge isPalindrome
        fast = head;
        slow = pre;
        while (slow != null && fast != null) {
            if (slow.val != fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}

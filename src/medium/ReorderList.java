package medium;

import base.ListNode;

/**
 * Created by rrr on 2017/6/5.
 * 143. Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
//    Submission Result: Runtime Error More Details
//    Runtime Error Message:
//    Line 31: java.lang.StackOverflowError
    //思路：递归的遍历链表，保持一个尾结点的前一个结点，然后当i+j==len时进行交换
    public static void reorderList(ListNode head) {
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        reorder(node1, 1, node2, 1, len);
    }

    private static ListNode reorder(ListNode head, int i, ListNode preRear, int j, int len) {
        if (i > len / 2||preRear==null||head==null) return null;
        if (i + j == len) {
            ListNode rear = preRear.next;
            rear.next = head.next;
            head.next = rear;
            preRear.next = null;
            return rear;
        } else {
            head = reorder(head, i, preRear.next, j + 1, len);
            reorder(head==null?null:head.next, i + 1, preRear, j, len);
            return null;
        }
    }
    //LeetCode解法
    //思路：1.利用快慢指针找到中间结点的前一个结点和尾结点的前一个结点    1,2,3,4,5,6
    //2.保存中间结点的前一个结点，将后一半结点翻转    1,2,3,6,5,4
    //3.一个一个结点链接起来1,6,2,5,3,4
    public static void reorderList2(ListNode head) {
        if (head==null||head.next==null)return;
        ListNode l2=head,l1=head;
        //step1
        while (l2.next!=null&&l2.next.next!=null){
            l1=l1.next;
            l2=l2.next.next;
        }
        //step2
        ListNode preMid=l1;
        ListNode cur=l1.next;
        while (cur.next!=null){
            ListNode next=cur.next;
            cur.next=next.next;
            next.next=preMid.next;
            preMid.next=next;
        }
        //step3
        l1=head;
        l2=preMid.next;
        while (l1!=preMid){
            preMid.next=l2.next;
            l2.next=l1.next;
            l1.next=l2;
            l1=l2.next;
            l2=preMid.next;
        }
    }
    //LeetCode解法
    //思路：与上面相同，但是更好理解
    public void reorderList3(ListNode head) {
        if (head == null || head.next == null)
            return;

        // step 1. cut the list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // step 2. reverse the 2nd half
        ListNode l2 = reverse(slow);

        // step 3. merge the two halves
        merge(l1, l2);
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode head=node;
        node.next = new ListNode(2);node=node.next;
        node.next = new ListNode(3);node=node.next;
        node.next = new ListNode(4);node=node.next;;
        node.next = new ListNode(5);
        reorderList(head);
    }
}

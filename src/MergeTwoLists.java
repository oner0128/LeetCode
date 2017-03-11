import java.util.List;

/**
 * Created by rrr on 2017/3/11.
 */
public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode head;
        if (l1 == null) {
            head = new ListNode(l2.val);
            l2 = l2.next;
        } else if (l2 == null) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode node = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return head;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l2.next, l1);
            return l2;
        }
    }
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists3(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists3(l1, l2.next);
        }
        return mergeHead;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1head = l1;
        ListNode l2 = new ListNode(2);
        ListNode l2head = l2;
        for (int i = 1; i < 5; i++) {
            l1.next = new ListNode(2 * i + 1);
            l1 = l1.next;
        }
        for (int i = 2; i < 6; i++) {
            l2.next = new ListNode(2 * i);
            l2 = l2.next;
        }
//        for (int i = 900; i < 1200; i++) {
//            System.out.printf(i + ",");
//        }
//       while (l1head!=null){
//           System.out.printf(l1head.val+" ");
//           l1head=l1head.next;
//       }
//        System.out.println();
//        while (l2head!=null){
//            System.out.printf(l2head.val+" ");
//            l2head=l2head.next;
//        }System.out.println();
        ListNode r = mergeTwoLists2(l1head, l2head);
        while (r != null) {
            System.out.printf(r.val + " ");
            r = r.next;
        }
    }
}

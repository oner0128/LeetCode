import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 1-3-5
 * 2-4-6
 * =1-2-3-4-5-6
 */
public class MergeListNode {
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(0);
        ListNode d=head;
        while (list1 != null || list2 != null) {
            int one=list1==null?Integer.MAX_VALUE:list1.val;
            int two=list2==null?Integer.MAX_VALUE:list2.val;
            if (one<two){d.next=new ListNode(list1.val);list1=list1.next;}
            else {d.next=new ListNode(list2.val);list2=list2.next;}
            d=d.next;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode root=new ListNode(1);
        ListNode d=root;
        for (int i = 1; i < 6; i+=2) {
            d.next=new ListNode(i);
            d=d.next;
        }
        ListNode root2=new ListNode(1);
        ListNode d2=root2;
        for (int i = 2; i < 6; i+=2) {
            d2.next=new ListNode(i);
            d2=d2.next;
        }
        root=root.next;root2=root2.next;
        Merge(root,root2);
    }
}

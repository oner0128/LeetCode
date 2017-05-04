import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrr on 2017/5/3.
 */
public class PrintListFromTailToHead {
    ArrayList<Integer>result;
    //recursive
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        result=new ArrayList<>();
        helper(result,listNode);
        return result;
    }

    private ListNode helper(ArrayList<Integer> result, ListNode head) {
        if (head==null)return head;
        if (head.next==null){result.add(head.val);return head;}
        ListNode p=helper(result,head.next);
        result.add(head.val);
        head.next.next=head;
        head.next=null;
        return p;
    }

    //iterative
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode==null)return new ArrayList<>();
        ArrayList<Integer>res=new ArrayList<>();
        ListNode pre=null;
        ListNode cur=listNode;
        while (cur!=null){
            ListNode nextNode=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextNode;
        }
        while (pre!=null){
            res.add(pre.val);
            pre=pre.next;
        }
        return res;
    }
}

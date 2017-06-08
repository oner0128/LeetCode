package medium;

/**
 * Created by rrr on 2017/6/8.
 * 86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class PartitionList {
    //思路：利用两个指针分别保存小于X的结点与大于X的结点
    public ListNode partition(ListNode head, int x) {
        ListNode lesshead=new ListNode(0),less=lesshead,morehead=new ListNode(0),more=morehead;
        while (head!=null){
            ListNode next=head.next;
            if (head.val<x){less.next=head;less=less.next;}
            else {
                more.next=head;more=more.next;
            }
            head.next=null;// 将less或more的下一个结点至空。否则会形成环
            head=next;
        }
        less.next=morehead.next;
        return lesshead.next;
    }
}

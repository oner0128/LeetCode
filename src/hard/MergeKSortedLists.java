package hard;

import base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rrr on 2017/6/17.
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedLists {
    //LeetCode解法 迭代  19ms
    // 思路：将链表放入最小堆中，每次取出堆顶链表，并得到该链表的当前结点，
    // 若该链表还有下一个结点，则继续将该链表放入堆中
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val <= o2.val ? -1 : 1;
            }
        });
        ListNode prehead = new ListNode(0);
        ListNode cur = prehead;
        for (ListNode listNode : lists) if (listNode != null) priorityQueue.offer(listNode);
        while (!priorityQueue.isEmpty()){
            cur.next=priorityQueue.poll();
            cur=cur.next;
            if (cur.next!=null)priorityQueue.offer(cur.next);
        }
        return prehead.next;
    }
    //LeetCode解法 递归  15ms
    // 思路：分治算法 类似归并排序
    // e.g. 有4条链表，1st和2nd、3rd和4th先分别合并，然后得到的两条链表再合并
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists,0,lists.length-1);
    }

    private ListNode helper(ListNode[] lists, int lo, int hi) {
        if (lo==hi)return lists[lo];
        if (lo<hi){
            int mid=(lo+hi)/2;
            ListNode l1=helper(lists,lo,mid);
            ListNode l2=helper(lists,mid+1,hi);
            return merge(l1,l2);
        }
        return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1==null)return l2;
        if (l2==null)return l1;
        if (l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}

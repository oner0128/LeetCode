/**
 * Created by rrr on 2017/5/7.
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int listNode1Nums = 0;
        int listNode2Nums = 0;
        ListNode list1 = pHead1;
        ListNode list2 = pHead2;
        //count nums of listnode
        while (list1 != null) {
            listNode1Nums++;
            list1 = list1.next;
        }
        while (list2 != null) {
            listNode2Nums++;
            list2 = list2.next;
        }
        //将长链表先移动多出来的结点
        list1 = pHead1;
        list2 = pHead2;
        if (listNode1Nums != listNode2Nums) {
            if (listNode1Nums > listNode2Nums) {
                int num = listNode1Nums - listNode2Nums;
                while (num>0&&list1 != null) {
                    num--;
                    list1 = list1.next;
                }
            } else {
                int num = listNode2Nums - listNode1Nums;
                while (num>0&&list2 != null) {
                    listNode2Nums++;num--;
                    list2 = list2.next;
                }
            }
        }
        //寻找第一个公共结点
        while (list1!=null&&list2!=null&&list1.val != list2.val) {
            list1 = list1.next;list2 = list2.next;
        }
        return list1;
    }
}

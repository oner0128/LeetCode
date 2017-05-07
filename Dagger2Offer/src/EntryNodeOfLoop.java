/**
 * Created by rrr on 2017/5/7.
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null||pHead.next==null) return null;
        ListNode oneStep = pHead;
        ListNode twoStep = pHead;
        while (oneStep != null && twoStep != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next == null ? null : twoStep.next.next;
            if (oneStep.val == twoStep.val) break;
        }
        if (oneStep == null || twoStep == null) return null;
        int count = 1;
        ListNode meetingNode=oneStep;
        while (oneStep.next != meetingNode) {
            count++;
            oneStep = oneStep.next;
        }
        oneStep = pHead;
        while (count > 0){ oneStep = oneStep.next;count--;}
        twoStep = pHead;
        while (oneStep != null && twoStep != null) {
            if (oneStep.val == twoStep.val) break;
            oneStep = oneStep.next;
            twoStep = twoStep.next;
        }
        return twoStep;
    }
}

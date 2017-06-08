package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/6/8.
 * 138. Copy List with Random Pointer
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.
 */
public class CopyListwithRandomPointer {
    //不会做
    //leetcode解法1
    //需要分清deep copy和shallow copy的区别
    //难点：因为是深拷贝，copyList.random=list.random令copyList.random指向了原链表，无法指向自己的结点，因为它不想next是new出来的
    //思路：需要三次遍历
    //1，第一次遍历，对原链表的每个结点进行复制并插入原结点的后面
    //2，第二次遍历，对random指针进行修改
    //3，第三次遍历分离原链表和复制链表
    //2 ms
    public RandomListNode copyRandomList(RandomListNode head) {
        //first round
        RandomListNode cur=head,next;
        while (cur!=null){
            RandomListNode copy=new RandomListNode(cur.label);
            next=cur.next;
            cur.next=copy;
            copy.next=next;
            cur=next;
        }
        //second round
        cur=head;
        while (cur!=null){
            if (cur.random!=null){
                cur.next.random=cur.random.next;//修改复制链表的random指针，复制链表的random指针即为cur指针random的下一个结点
            }
            cur=cur.next.next;//只遍历原链表
        }
        //third round
        cur=head;
        RandomListNode copyhead=new RandomListNode(0);
        RandomListNode copy=copyhead;
        while (cur!=null){
            next=cur.next.next;
            copy.next=cur.next;
            copy=copy.next;
            cur.next=next;
            cur=next;
        }
        return copyhead.next;
    }
    //leetcode解法2
    //思路：利用Hashmap，key=oldNode，value=newnode
    //8 ms
    public static RandomListNode copyRandomList2(RandomListNode head) {
        if (head==null)return null;
        final Map<RandomListNode,RandomListNode>map=new HashMap<>();
        RandomListNode node=head;
        while (node!=null){
            map.put(node,new RandomListNode(node.label));
            node=node.next;
        }
        for (Map.Entry<RandomListNode,RandomListNode>entry:map.entrySet()){
            entry.getValue().next=map.get(entry.getKey().next);
            entry.getValue().random=map.get(entry.getKey().random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        RandomListNode node=new RandomListNode(-1);
        node.random=node;
        RandomListNode newnode=copyRandomList2(node);
    }

}
  class RandomListNode {
     int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; } };
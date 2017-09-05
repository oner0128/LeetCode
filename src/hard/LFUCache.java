package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/9/5.
 * 460. LFU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * // LRUCache cache = new LRUCache( 2 ) (capacity)
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LFUCache {
    class DLinkNode {
        int key, value,use;
        DLinkNode next, pre;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
            use=0;
        }

        public DLinkNode() {
            this(0, 0);
        }
    }

    Map<Integer, DLinkNode> map ;
    int count, capacity;
    DLinkNode head, tail;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) return -1;
        node.use++;
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity==0)return;
        DLinkNode node = map.get(key);
        if (node == null) {
            count++;
            if (count>capacity){
                DLinkNode lastNode=tail.pre;
                remove(lastNode);
                map.remove(lastNode.key);
                count--;
            }
            node = new DLinkNode(key, value);
            map.put(key, node);
            add(node);
        } else {
            node.value=value;
            node.use++;
            update(node);
        }
    }

    private void update(DLinkNode node) {
        DLinkNode pre = node.pre;
        remove(node);
        while (pre!=head&&pre.use<=node.use){
            pre=pre.pre;
        }
        DLinkNode after=pre.next;
        pre.next=node;
        node.pre=pre;
        node.next=after;
        after.pre=node;
    }

    private void add(DLinkNode node) {
        DLinkNode pre = tail.pre;
        while (pre!=head&&pre.use<=node.use){
            pre=pre.pre;
        }
        DLinkNode after=pre.next;
        pre.next=node;
        node.pre=pre;
        node.next=after;
        after.pre=node;
    }

    private void remove(DLinkNode node) {
        DLinkNode after = node.next, pre = node.pre;
        pre.next = after;
        after.pre = pre;
    }

    public static void main(String[] args) {
        LFUCache cache=new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.get(3);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


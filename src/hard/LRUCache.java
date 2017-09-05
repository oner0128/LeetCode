package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/9/5.
 * 146. LRU Cache
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
public class LRUCache {
    class DLinkNode {
        int key, value;
        DLinkNode next, pre;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkNode() {
            this(0, 0);
        }
    }

    Map<Integer, DLinkNode> map ;
    int count, capacity;
    DLinkNode head, tail;

    public LRUCache(int capacity) {
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

        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node == null) {
            node = new DLinkNode(key, value);
            map.put(key, node);
            add(node);
            count++;
        } else {
            node.value=value;
            update(node);
        }
        if (count>capacity){
            DLinkNode lastNode=tail.pre;
            remove(lastNode);
            map.remove(lastNode.key);
            count--;
        }
    }

    private void update(DLinkNode node) {
        remove(node);
        add(node);
    }

    private void add(DLinkNode node) {
        DLinkNode after = head.next;
        head.next = node;
        node.pre = head;
        node.next = after;
        after.pre = node;
    }

    private void remove(DLinkNode node) {
        DLinkNode after = node.next, pre = node.pre;
        pre.next = after;
        after.pre = pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


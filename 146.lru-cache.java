import java.util.HashMap;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node (int a, int b) {
            key = a;
            val = b;
        }
    }

    class DoubleList {  
        private Node head, tail; // 头尾虚节点
        private int size; // 链表元素数
    
        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
    
        // 在链表头部添加节点 x
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }
    
        // 删除链表中的 x 节点（x 一定存在）
        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }
        
        // 删除链表中最后一个节点，并返回该节点
        public Node removeLast() {
            if (tail.prev == head)
                return null;
            Node last = tail.prev;
            remove(last);
            return last;
        }
        
        // 返回链表长度
        public int size() { return size; }
    }

    private HashMap<Integer, Node> map;
    private DoubleList list;
    private int len;
    
    // 哈希表用于值的取
    // 自定义双向链表的实现
    // 双向链表用于增删，使用双向是为了保证增删O(1)

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoubleList();
        len = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        Node cur = new Node(key, value);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(cur);
            map.put(key, cur);
        } else {
            if (len == list.size()) {
                Node last = list.removeLast();
                map.remove(last.key);
                list.addFirst(cur);
                
            } else {
                list.addFirst(cur);
            }
            map.put(key, cur);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end


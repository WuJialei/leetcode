/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {

    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        /*
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node node = new Node(head.val, null, null);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
        */

        if (head == null) {
            return null;
        }

        Node cur = head;
        while(cur != null) {
            Node node = new Node(cur.val, null, null);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }

        Node curr = head;
        while(curr != null) {
            curr.next.random = (curr.random == null) ? null: curr.random.next;
            curr = curr.next.next;
        }

        Node oldList = head;
        Node ret = head.next;
        Node newList = ret;
        while(oldList != null) {
            oldList.next = newList.next;
            newList.next = (newList.next == null) ? null: newList.next.next;
            oldList = oldList.next;
            newList = newList.next;
        }

        return ret;

    }
}
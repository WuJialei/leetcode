/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public class MyNode {
        Node first;
        Node last;
    }

    public MyNode dfs (Node node) {
        if (node == null) {
            return null;
        }
        MyNode ans = new MyNode();
        ans.first = node;
        while (node != null) {
            
            if (node.child != null) {
                Node cur = node;
                Node next = node.next;
                MyNode tmp = dfs(cur.child);
                node.next = tmp.first;
                tmp.first.prev = node;
                node.child = null;
                if (next != null) {
                    next.prev = tmp.last;
                    tmp.last.next = next;
                    
                }
                ans.last = next == null ? tmp.last : next;
                node = next;
            } else {
                ans.last = node;
                node = node.next;
            }
            
        }
        
        return ans;
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        MyNode myNode = dfs(head);
        return myNode.first;
    }
}
// @lc code=end


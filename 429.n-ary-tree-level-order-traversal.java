import java.util.Queue;

import com.sun.org.apache.bcel.internal.classfile.Node;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> children = new ArrayList<Node>();
            List<Integer> temp = new ArrayList<Integer>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                temp.add(node.val);
                for (Node child : node.children) {
                    children.add(child);
                }
            }
            ans.add(temp);
            queue.addAll(children);
        }
        return ans;
    }
}
// @lc code=end


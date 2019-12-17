/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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

    List<Integer> ans;

    public List<Integer> postorder(Node root) {
        ans = new ArrayList<Integer>();
        // dfs(root);
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(0, node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        return ans;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child);
            }
        }
        ans.add(node.val);
    }

}
// @lc code=end


/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
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
    public int maxDepth(Node root) {
        return depth(root);
    }

    public int depth(Node node) {
        if (node == null) {
            return 0;
        } else if (node.children == null) {
            return 1;
        } else {
            int ans = 0;
            for (Node child : node.children) {
                ans = Math.max(ans, depth(child));
            }
            return ans + 1;
        }

    }

}
// @lc code=end


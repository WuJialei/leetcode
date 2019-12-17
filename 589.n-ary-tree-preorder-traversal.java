import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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

    public List<Integer> preorder(Node root) {
        ans = new ArrayList<Integer>();
        // dfs(root);
        Stack<Node> stack = new Stack<Node>();
        if (root == null) {
            return ans;
        }
        
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; --i) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return ans;
    }

    public void dfs(Node node) {
        if (node == null) {
            return;
        }
        ans.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child);
            }
        }
    }

}
// @lc code=end


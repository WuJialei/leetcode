import java.util.HashMap;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int _val = node.val;
        Node ans = new Node(_val, new ArrayList<>());
        map.put(node, ans);        
        ArrayList<Node> _neighbors = new ArrayList<>();
        for (Node t : node.neighbors) {
            Node nei = cloneGraph(t);
            ans.neighbors.add(nei);
        }
        return ans;
    }
}
// @lc code=end


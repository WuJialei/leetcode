import java.util.HashMap;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1145 lang=java
 *
 * [1145] Binary Tree Coloring Game
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private HashMap<Integer, Integer> cntMap;
    private HashMap<Integer, TreeNode> nodeMap;

    public int dfs (TreeNode node) {
        if (node == null) {
            return 0;
        }
        nodeMap.put(node.val, node);
        int ans = 1;
        if (node.left != null) {
            ans += dfs(node.left);
        }
        if (node.right != null) {
            ans += dfs(node.right);
        }
        cntMap.put(node.val, ans);
        return ans;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root == null) {
            return false;
        }
        // 基于贪心算法，找x节点的左、右、除去以该节点为根的其他所有节点的节点数，相当于封住了x节点的某个方向，
        // 看是否找出的节点数大于n/2
        cntMap = new HashMap<>();
        nodeMap = new HashMap<>();
        cntMap.put(root.val, n);
        nodeMap.put(root.val, root);
        dfs(root);
        if (root.val == x) {
            TreeNode cur = nodeMap.get(x);
            if (cur.left != null && cntMap.get(cur.left.val) > n/2) {
                return true;
            }
            if (cur.right != null && cntMap.get(cur.right.val) > n/2) {
                return true;
            }
            return false;
        } else {
            TreeNode cur = nodeMap.get(x);
            if (n - cntMap.get(cur.val) > n/2) {
                return true;
            }
            if (cur.left != null && cntMap.get(cur.left.val) > n/2) {
                return true;
            }
            if (cur.right != null && cntMap.get(cur.right.val) > n/2) {
                return true;
            }
            return false;
        }
    }
}
// @lc code=end


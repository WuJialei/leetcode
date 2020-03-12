/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public class Point{
        int c0;
        int c1;
        public Point(int x, int y){
            c0 = x;
            c1 = y;
        }
    }

    public Point dfs (TreeNode node) {
        if (node == null ) {
            return new Point(0, 0);
        }
        // 0表示到不偷该节点的以该节点为根的最大偷盗和
        // 1表示到偷该节点的以该节点为根的最大偷盗和
        // root[0] = max{left[0], left[1]} + max{right[0], right[1]}
        // root[1] = root.val + left[0] + right[0]
        Point left = dfs(node.left);
        Point right = dfs(node.right);
        int c0 = Math.max(left.c0, left.c1) + Math.max(right.c0, right.c1);
        int c1 = node.val + left.c0 + right.c0;
        return new Point(c0, c1);
    }

    public int rob(TreeNode root) {
        Point ans  = dfs(root);
        return Math.max(ans.c0, ans.c1);
    }
}
// @lc code=end


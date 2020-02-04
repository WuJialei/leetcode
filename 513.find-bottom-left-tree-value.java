import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=513 lang=java
 *
 * [513] Find Bottom Left Tree Value
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
    int ans;
    int maxDepth;
    public int findBottomLeftValue(TreeNode root) {
        /*
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<TreeNode>();
            TreeNode node1 = queue.poll();
            ans = node1.val;
            if (node1.left != null) {
                temp.add(node1.left);
            }
            if (node1.right != null) {
                temp.add(node1.right);
            }
            while (!queue.isEmpty()) {
                TreeNode node2 = queue.poll();
                if (node2.left != null) {
                    temp.add(node2.left);
                }
                if (node2.right != null) {
                    temp.add(node2.right);
                }
            }
            queue.addAll(temp);
        }
        return ans;
        */
        ans = root.val;
        maxDepth = -1;
        helper(root, 0);
        return ans;
    }

    public void helper(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        helper(node.left, depth + 1);
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = node.val;
        }
        helper(node.right, depth + 1);
    }

}
// @lc code=end


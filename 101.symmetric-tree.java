import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 != null && node2 != null) {
                if (node1.val != node2.val) {
                    return false;
                }          
            } else {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public boolean dfs (TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            } else {
                return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
            }            
        } else {
            return false;
        }
    }

}
// @lc code=end


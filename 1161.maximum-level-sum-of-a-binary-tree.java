import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=1161 lang=java
 *
 * [1161] Maximum Level Sum of a Binary Tree
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int index = 1;
        int cnt = 1;
        int sum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int tempSum = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                tempSum += node.val;
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            if (tempSum > sum) {
                index = cnt;
                sum = tempSum;
            }
            ++cnt;
            queue.addAll(list);
        }
        return index;
    }
}
// @lc code=end


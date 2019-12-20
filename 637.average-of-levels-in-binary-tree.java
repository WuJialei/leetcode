import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
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

    Queue<TreeNode> queue;

    public List<Double> averageOfLevels(TreeNode root) {
        queue = new LinkedList<TreeNode>();
        List<Double> list = new ArrayList<Double>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new LinkedList<TreeNode>();
            int cnt = 0;
            double sum = 0;
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                ++cnt;
                sum += node.val;
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            list.add(sum/cnt);
            queue = tmp;
        }
        return list;
    }
}
// @lc code=end


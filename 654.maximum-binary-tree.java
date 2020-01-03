/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
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

    boolean[] visited;
    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        this.nums = nums;
        visited = new boolean[len];
        return dfs(0, len - 1);
    }

    public TreeNode dfs (int start, int end) {
        if (start > end) {
            return null;
        }
        int index = start;
        int maxVal = nums[start];
        for (int i = start; i <= end; ++i) {
            if (!visited[i] && nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        if (visited[index]) {
            return null;
        }
        visited[index] = true;
        TreeNode node = new TreeNode(nums[index]);
        node.left = dfs(start, index - 1);
        node.right = dfs(index + 1, end);
        return node;
    }

}
// @lc code=end


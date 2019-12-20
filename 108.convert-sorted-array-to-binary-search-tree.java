/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return bs(nums, 0, nums.length-1);
    }

    public TreeNode bs(int[] arrays, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(arrays[mid]);
        node.left = bs(arrays, start, mid - 1);
        node.right = bs(arrays, mid + 1, end);
        return node;
    }

}
// @lc code=end


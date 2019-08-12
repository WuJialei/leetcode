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
        if (nums.length == 0) {
        	return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = (mid - 1 >= 0) ? sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid)): null;
        root.right = (mid + 1 < nums.length) ? sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length)): null;
        return root;
    }
}
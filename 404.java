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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        int cntLeftLeaves = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
            	cntLeftLeaves += root.left.val;
            } else {
            	cntLeftLeaves = sumOfLeftLeaves(root.left);
            }

        }
        int cntRightLeaves = sumOfLeftLeaves(root.right);
        return cntRightLeaves + cntLeftLeaves;
    }
}
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

	private int maxValue = 0;

    public int longestUnivaluePath(TreeNode root) {
        depth(root);
        return maxValue;
    }

    public int depth(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	int leftDepth = depth(node.left);
    	int rightDepth = depth(node.right);
    	int leftUnivalue = node.left != null && node.left.val == node.val? leftDepth+1 : 0; 
    	int rightUnivalue = node.right != null && node.right.val == node.val? rightDepth+1 : 0; 
    	maxValue = Math.max(maxValue, leftUnivalue + rightUnivalue);
    	return Math.max(leftUnivalue, rightUnivalue);
    }

}
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

	private int minValue = 0;

    public int findSecondMinimumValue(TreeNode root) {
        minValue = root.val;
        int secondMinValue = -1;
        if (root.left != null) {
        	int leftSecond = getSecondMinValue(root.left);
        	int rightSecond = getSecondMinValue(root.right);
        	if (leftSecond == -1 && rightSecond == -1) {
        		return -1;
        	}
        	if (leftSecond == -1 || rightSecond == -1) {
        		return Math.max(leftSecond, rightSecond);
        	}
        	return Math.min(leftSecond, rightSecond);
        } else {
        	return -1;
        }
    }

    public int getSecondMinValue(TreeNode node) {
    	if (node == null) {
    		return -1;
    	}
    	if (node.val > minValue) {
    		return node.val;
    	} 
    	if (node.left != null) {
        	int leftSecond = getSecondMinValue(node.left);
        	int rightSecond = getSecondMinValue(node.right);
        	if (leftSecond == -1 && rightSecond == -1) {
        		return -1;
        	}
        	if (leftSecond == -1 || rightSecond == -1) {
        		return Math.max(leftSecond, rightSecond);
        	}
        	return Math.min(leftSecond, rightSecond);
        } else {
        	return -1;
        }
    }

}
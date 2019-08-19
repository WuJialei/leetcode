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

	private List<Integer> result;

    public int kthSmallest(TreeNode root, int k) {
    	result = new ArrayList<>();
        inOrder(root);
        return result.get(k-1);
    }

    public void inOrder(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	inOrder(node.left);
    	result.add(node.val);
    	inOrder(node.right);
    }

}
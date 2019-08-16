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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode ret = root;
        while(!queue.isEmpty()) {
        	ret = queue.poll();
        	if (ret.right != null) {
        		queue.offer(ret.right);
        	}
        	if (ret.left != null) {
        		queue.offer(ret.left);
        	}
        }
        return ret.val;
    }
}
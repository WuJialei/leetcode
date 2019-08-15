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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new LinkedList<>();
        if (root == null) {
        	return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	int cnt = queue.size();
        	int nodeNum = cnt;
        	double sum = 0;
        	while(cnt > 0) {
        		TreeNode node = queue.poll();
        		sum += node.val;
        		if (node.left != null) {
        			queue.offer(node.left);
        		}
        		if (node.right != null) {
        			queue.offer(node.right);
        		}
        		--cnt;
        	}
        	ret.add(sum/nodeNum);
        }
        return ret;
    }
}
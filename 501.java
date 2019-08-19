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

	private TreeNode preNode;
	private int cnt = 1;
	private int maxCnt = 1;
	private List<Integer> result;

    public int[] findMode(TreeNode root) {
    	result = new ArrayList<Integer>();
        inOrder(root);
        int[] ret = new int[result.size()];
        int index = 0;
        for (int num : result) {
            ret[index++] = num;
        }
        return ret;
    }

    public void inOrder(TreeNode node) {
    	if (node == null) {
    		return;
    	}
    	inOrder(node.left);
        if(preNode != null) {
            if (preNode.val == node.val) {
                ++cnt;
            } else {
                cnt = 1;
            }
        }
    	if (cnt > maxCnt) {
    		result.clear();
    		maxCnt = cnt;
    		result.add(node.val);
    	} else if (cnt == maxCnt) {
    		result.add(node.val);
    	}
        preNode = node;
    	inOrder(node.right);
    }

}
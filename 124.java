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

    int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftV = Math.max(dfs(node.left), 0);
        int rightV = Math.max(dfs(node.right), 0);
        int path = node.val + leftV + rightV;
        ans = Math.max(ans, path);
        return node.val + Math.max(leftV, rightV);
    }

}
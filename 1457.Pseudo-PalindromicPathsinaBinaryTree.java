/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        int nums = 0;
        dfs(root, nums);
        return ans;
    }

    public void dfs(TreeNode root, int temp) {
        int n = temp ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if (n == 0 || (n & (n - 1)) == 0) {
                ++ans;
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, n);
        }
        if (root.right != null) {
            dfs(root.right, n);
        }
    }
}

/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
 */

// @lc code=start
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

    List<Integer> ans1;
    List<Integer> ans2;

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ans1 = new ArrayList<Integer>();
        ans2 = new ArrayList<Integer>();
        dfs(ans1, root1);
        dfs(ans2, root2);
        if (ans1.size() != ans2.size()) {
            return false;
        } else {
            for (int i = 0; i < ans1.size(); ++i) {
                if (ans1.get(i) != ans2.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public void dfs(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            list.add(node.val);
        } else {
            if(node.left != null) {
                dfs(list, node.left);
            }
            if(node.right != null){
                dfs(list, node.right);
            }
        }
    }

}
// @lc code=end


import java.util.HashSet;

/*
 * @lc app=leetcode id=1261 lang=java
 *
 * [1261] Find Elements in a Contaminated Binary Tree
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
class FindElements {

    HashSet<Integer> set = new HashSet<Integer>();

    public FindElements(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val = 0;
        set.add(root.val);
        dfs(root);
    }


    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            set.add(node.left.val);
            dfs(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            set.add(node.right.val);
            dfs(node.right);
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
// @lc code=end


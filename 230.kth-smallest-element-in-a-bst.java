import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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

    private List<Integer> list;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        list = new ArrayList<>();
        inOrder(root);
        return list.get(k-1);
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (list.size() >= k) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

}
// @lc code=end


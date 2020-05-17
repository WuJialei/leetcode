import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * @lc app=leetcode id=988 lang=java
 *
 * [988] Smallest String Starting From Leaf
 */

// @lc code=start
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

    private List<String> ans;

    public void dfs (TreeNode node, String str) {
        if (node == null) {
            return;
        }
        char cur = (char)(node.val + 'a');
        if (node.left == null && node.right == null) {
            ans.add(cur + str);
            return;
        }
        if (node.left != null) {
            dfs(node.left, cur + str);
        }
        if (node.right != null) {
            dfs(node.right, cur + str);
        }
        return;
    }

    public int transfer(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum = sum * 10 + (c - 'a');
        }
        return sum;
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        ans = new ArrayList<>();
        dfs(root, "");
        Collections.sort(
            ans,
            (a, b) -> {
                return a.compareTo(b);
                // return transfer(a) - transfer(b);
                // if (a.length() != b.length()) {
                //     return a.length() - b.length();
                // } else {
                //     return a.compareTo(b);
                // }
            }
        );
        // StringBuilder sb = new StringBuilder();
        // for (char c : ans.get(0).toCharArray()) {
        //     int add = c - '0';
        //     sb.append((char)(add + 'a'));
        // }
        return ans.get(0);
    }
}
// @lc code=end


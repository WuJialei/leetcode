import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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

    // Map<Integer, TreeNode> parent;
    // Map<Integer, Integer> depth;

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }
        if (root.val == x || root.val == y) {
            return false;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            boolean xFlag = false;
            boolean yFlag = false;
            int xParent = -1;
            int yParent = -1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    temp.offer(node.left);
                    if (node.left.val == x) {
                        xFlag = true;
                        xParent = node.val;
                    } else if (node.left.val == y) {
                        yFlag = true;
                        yParent = node.val;
                    }
                }
                if (node.right != null) {
                    temp.offer(node.right);
                    if (node.right.val == x) {
                        xFlag = true;
                        xParent = node.val;
                    } else if (node.right.val == y) {
                        yFlag = true;
                        yParent = node.val;
                    }
                }
            }
            if (xFlag || yFlag) {
                if (xFlag && yFlag) {
                    return xParent == yParent ? false : true;
                }
                return false;
            }
            queue = temp;
        }
        return false;

        // parent = new HashMap<Integer, TreeNode>();
        // depth = new HashMap<Integer, Integer>();
        // dfs(new TreeNode(-1), root, 0);
        // return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);

    }

    // public void dfs (TreeNode pre, TreeNode node, int cnt) {
    //     if (node == null) {
    //         return;
    //     }
    //     depth.put(node.val, cnt);
    //     parent.put(node.val, pre);
    //     dfs(node, node.left, cnt + 1);
    //     dfs(node, node.right, cnt + 1);
    // }

}
// @lc code=end


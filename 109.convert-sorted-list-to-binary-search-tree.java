import java.util.ArrayList;

/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    private ArrayList<Integer> list;

    public TreeNode dfs(int left, int right) {
        if (left == right) {
            return new TreeNode(list.get(left));
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = dfs(left, mid-1);
        node.right = dfs(mid+1, right);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode root = dfs(0, list.size() - 1);
        return root;
    }
}
// @lc code=end


import java.util.ArrayList;

/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 *
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (43.26%)
 * Likes:    1335
 * Dislikes: 75
 * Total Accepted:    201K
 * Total Submissions: 463.9K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example:
 * 
 * 
 * Given the sorted linked list: [-10,-3,0,5,9],
 * 
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following
 * height balanced BST:
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ArrayList<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
        list = new ArrayList<Integer>();
        // 升序数组映射为平衡二叉树，分数组长度为奇数和偶数情况考虑，奇数情况肯定是平衡二叉树，偶数情况是少一个元素的
        // 奇数情况，可推理得知也是平衡二叉树
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return dfs(0, list.size()-1);
    }

    public TreeNode dfs (int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(list.get(left));
        }
        int mid = (right - left)/2 + left;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(left, mid - 1);
        root.right = dfs(mid+1, right);
        return root;
    }
}
// @lc code=end


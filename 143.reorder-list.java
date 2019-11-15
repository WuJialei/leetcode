/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (32.99%)
 * Likes:    1190
 * Dislikes: 88
 * Total Accepted:    181.8K
 * Total Submissions: 549.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode ret = new ListNode(0);
        ListNode ans = ret;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverse(slow.next);
        slow.next = null;
        ListNode left = head;
        while (right != null) {
            ListNode temp = new ListNode(right.val);
            right = right.next;
            ListNode index = left.next;
            left.next = temp;
            temp.next = index;
            left = left.next.next;
        }
    }

    public ListNode reverse (ListNode node) {
        ListNode ans = null;
        while (node != null) {
            ListNode temp = new ListNode(node.val);
            temp.next = ans;
            ans = temp;
            node = node.next;
        }
        return ans;
    }


}
// @lc code=end


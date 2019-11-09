/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 *
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (46.99%)
 * Likes:    1495
 * Dislikes: 136
 * Total Accepted:    373.3K
 * Total Submissions: 794.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode left = p;
        ListNode q = new ListNode(0);
        ListNode right = q;
        boolean flag = true;
        while(head != null) {
            if (flag) {
                p.next = new ListNode(head.val);
                p = p.next;
            } else {
                q.next = new ListNode(head.val);
                q = q.next;
            }
            head = head.next;
            flag = !flag;
        }
        left = left.next;
        right = right.next;
        ListNode ans = new ListNode(0);
        ListNode ret = ans;
        while (left != null && right != null) {
            ans.next = new ListNode(right.val);
            ans.next.next =  new ListNode(left.val);
            ans = ans.next.next;
            right = right.next;
            left = left.next;
        }
        if (left != null) {
            ans.next = new ListNode(left.val);
        } 
        if (right != null) {
            ans.next = new ListNode(right.val);
        }
        return ret.next;
    }
}
// @lc code=end


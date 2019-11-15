/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (32.13%)
 * Likes:    6368
 * Dislikes: 1665
 * Total Accepted:    1.1M
 * Total Submissions: 3.4M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ret = ans;
        int addNum = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            ans.next = new ListNode((val + addNum)% 10);
            addNum = (val + addNum) / 10;
            ans = ans.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val;
            ans.next = new ListNode((val + addNum)% 10);
            addNum = (val + addNum) / 10;
            ans = ans.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val;
            ans.next = new ListNode((val + addNum)% 10);
            addNum = (val + addNum) / 10;
            ans = ans.next;
            l2 = l2.next;
        }
        while (addNum > 0) {
            int val = addNum;
            ans.next = new ListNode((val)% 10);
            addNum = (val) / 10;
            ans = ans.next;
        }
        return ret.next;
        // return reverse(ret.next);
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


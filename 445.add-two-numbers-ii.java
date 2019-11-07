/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
 *
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (51.78%)
 * Likes:    929
 * Dislikes: 123
 * Total Accepted:    115K
 * Total Submissions: 222.1K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The most significant digit comes first and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the
 * lists is not allowed.
 * 
 * 
 * 
 * Example:
 * 
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
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
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode ans = null;
        int flag = 0;
        while (!stack1.empty() && !stack2.empty()) {
            int sum = stack1.pop() + stack2.pop();
            ListNode node = new ListNode((sum + flag) % 10);
            flag = (sum + flag) / 10;
            node.next = ans;
            ans = node;
        }
        while (!stack1.empty()) {
            int sum = stack1.pop();
            ListNode node = new ListNode((sum + flag) % 10);
            flag = (sum + flag) / 10;
            node.next = ans;
            ans = node;
        }
        while (!stack2.empty()) {
            int sum = stack2.pop();
            ListNode node = new ListNode((sum + flag) % 10);
            flag = (sum + flag) / 10;
            node.next = ans;
            ans = node;
        }
        if (flag > 0) {
            ListNode node = new ListNode(flag);
            node.next = ans;
            ans = node;
        }
        return ans;
    }
}
// @lc code=end


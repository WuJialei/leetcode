/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 *
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (34.62%)
 * Likes:    2301
 * Dislikes: 174
 * Total Accepted:    478.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, remove the n-th node from the end of list and return
 * its head.
 * 
 * Example:
 * 
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * 
 * 
 * Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(0);
        ListNode ret = ans;

        ListNode temp = head;
        int cnt = 0;
        while (temp != null) {
            ++cnt;
            temp = temp.next;
        }

        int start = 1;
        int end = cnt - n + 1;

        while (start <= end && head != null) {
            if (start == end) {
                ans.next = head.next;
                break;
            } else {
                ans.next = new ListNode(head.val);
                head = head.next;
                ans = ans.next;
            }   
            ++start;         
        }
        return ret.next;
    }
}
// @lc code=end


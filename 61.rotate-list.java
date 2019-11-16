/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 *
 * https://leetcode.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (28.26%)
 * Likes:    778
 * Dislikes: 913
 * Total Accepted:    223.2K
 * Total Submissions: 788.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            ++cnt;
            p = p.next;
        }
        if (k % cnt == 0) {
            return head;
        }
        int index = cnt - k % cnt;
        ListNode q = head;
        int start = 1;
        while (start < index && q != null) {
            q = q.next;
            ++start;
        }
        ListNode ret = q.next;
        ListNode ans = ret;
        while (ret != null) {
            if (ret.next == null) {
                ret.next = head;
                break;
            }
            ret = ret.next;
        }
        q.next = null;
        return ans;
    }
}
// @lc code=end


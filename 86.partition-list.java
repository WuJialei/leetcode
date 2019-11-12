/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (38.87%)
 * Likes:    875
 * Dislikes: 228
 * Total Accepted:    184.4K
 * Total Submissions: 473.9K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode lessList = new ListNode(0);
        ListNode p = lessList;
        ListNode moreList = new ListNode(0);
        ListNode q = moreList;
        while (head != null) {
            if (head.val < x) {
                lessList.next = new ListNode(head.val);
                lessList = lessList.next;
            } else {
                moreList.next = new ListNode(head.val);
                moreList = moreList.next;
            }
            head = head.next;
        }
        lessList.next = q.next;
        return p.next;

    }
}
// @lc code=end


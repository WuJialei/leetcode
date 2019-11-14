import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (34.50%)
 * Likes:    1111
 * Dislikes: 90
 * Total Accepted:    209.1K
 * Total Submissions: 604.7K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * 
 * 
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 1->1->1->2->3
 * Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0)+1);
            temp = temp.next;
        }
        ListNode ans = new ListNode(0);
        ListNode ret = ans;
        while (head != null) {
            if (map.get(head.val) == 1) {
                ans.next = new ListNode(head.val);
                ans = ans.next;
            }
            head = head.next;
        }
        return ret.next;
    }
}
// @lc code=end


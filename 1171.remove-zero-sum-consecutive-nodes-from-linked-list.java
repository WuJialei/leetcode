/*
 * @lc app=leetcode id=1171 lang=java
 *
 * [1171] Remove Zero Sum Consecutive Nodes from Linked List
 *
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
 *
 * algorithms
 * Medium (41.64%)
 * Likes:    192
 * Dislikes: 18
 * Total Accepted:    7.2K
 * Total Submissions: 17.2K
 * Testcase Example:  '[1,2,-3,3,1]'
 *
 * Given the head of a linked list, we repeatedly delete consecutive sequences
 * of nodes that sum to 0 until there are no such sequences.
 * 
 * After doing so, return the head of the final linked list.  You may return
 * any such answer.
 * 
 * 
 * (Note that in the examples below, all sequences are serializations of
 * ListNode objects.)
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: head = [1,2,3,-3,4]
 * Output: [1,2,4]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: head = [1,2,3,-3,-2]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The given linked list will contain between 1 and 1000 nodes.
 * Each node in the linked list has -1000 <= node.val <= 1000.
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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
        ListNode ans = new ListNode(0);
        ans.next = head;
        int prefixSum = 0;
        map.put(0, ans);
        while (head != null) {
            prefixSum += head.val;
            if (map.containsKey(prefixSum)) {
                ListNode p = map.get(prefixSum);
                int sum = prefixSum;
                ListNode temp = p.next;
                while(temp != head) {
                    sum += temp.val;
                    map.remove(sum);
                    temp = temp.next;
                }
                p.next = head.next;
            } else {
                map.put(prefixSum, head);
            }
            head = head.next;

        }
        return ans.next;
    }
}
// @lc code=end


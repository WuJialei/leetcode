import java.util.List;

/*
 * @lc app=leetcode id=1019 lang=java
 *
 * [1019] Next Greater Node In Linked List
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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < list.size(); ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                    ans[stack.pop()] = list.get(i);
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
// @lc code=end


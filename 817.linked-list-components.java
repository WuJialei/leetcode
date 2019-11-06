import java.util.*;

/*
 * @lc app=leetcode id=817 lang=java
 *
 * [817] Linked List Components
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
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int t: G) {
            set.add(t);
        }
        int ans = 0;
        while(head != null) {
            // 找连通图结束的地方
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                ++ans;
            }
            head = head.next;
        }
        return ans;
    }
}
// @lc code=end


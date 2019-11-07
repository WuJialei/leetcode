/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode head = root;
        int cnt = 0;
        int[] arrays = new int[k];
        while (head != null) {
            ++cnt;
            head = head.next;
        }
        int avr = cnt / k;
        int mod = cnt % k;
        for (int i = 0; i < k; ++i) {
            if (mod > 0) {
                arrays[i] = avr + 1;
                --mod;
            } else {
                arrays[i] = avr;
            }
        }
        ListNode[] ans = new ListNode[k];
        for (int i = 0; i < k; ++i) {
            ListNode t = new ListNode(0);
            ListNode tt = t;
            while (arrays[i] > 0) {
                tt.next = new ListNode(root.val);
                root = root.next;
                tt = tt.next;
                --arrays[i];
            }
            ans[i] = t.next;
        }
        return ans;
    }
}
// @lc code=end


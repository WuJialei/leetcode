/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode oddNodes = new ListNode(head.val);
        ListNode oddNodesResult = oddNodes;
        ListNode evenNodes = new ListNode(head.next.val);
        ListNode evenNodesResult = evenNodes;;
        head = head.next.next;
        int cnt = 2;
        while (head != null) {
        	++cnt;
        	if ((cnt % 2) == 1) {
        		oddNodes.next = new ListNode(head.val);
        		oddNodes = oddNodes.next;
        	} else {
        		evenNodes.next = new ListNode(head.val);
        		evenNodes = evenNodes.next;
        	}
        	head = head.next;
        }
        oddNodes.next = evenNodesResult;
        return oddNodesResult;
    }
}
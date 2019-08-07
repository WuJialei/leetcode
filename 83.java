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
        if(head == null){
        	return null;
        }
        ListNode temp = new ListNode(head.val);
        ListNode result = temp;
        ListNode nextNode = head.next;
        while(nextNode != null){
        	if(nextNode.val == temp.val){
        		nextNode = nextNode.next;
        		continue;
        	}
            temp.next = new ListNode(nextNode.val);
            temp = temp.next;
            nextNode = nextNode.next;
        }
        return result;
    }
}
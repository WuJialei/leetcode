/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // ListNode res = null;
        if(head == null){
        	return null;
        }
        boolean flag = false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(slow == fast){
        		flag = true;
        		break;
        	}
        }
        if(!flag){
        	return null;
        }
        slow = head;
    	while(true){
    		if(slow == fast){
    			return slow;
    		}
    		slow = slow.next;
    		fast = fast.next;        		
    	}
    }
}
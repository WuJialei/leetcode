/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
        	return null;
        }
        ListNode result = null;
        Stack<Integer> temp = new Stack<>();
        while(head != null){
        	temp.push(head.val);
        	head = head.next;
        }
        if(!temp.empty()){
            ListNode t = new ListNode(temp.pop());
        	result = t;
        }
        ListNode res = result;
        while(!temp.empty()){
        	ListNode t = new ListNode(temp.pop());
        	result.next = t;
        	result = result.next;
        }
        return res;
    }
}
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
        	ListNode temp = head.next;
        	head.next = newHead;
        	newHead = head;
        	head = temp;
        }
        return newHead;
    }
}


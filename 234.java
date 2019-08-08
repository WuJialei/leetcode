/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) {
    		return true;
    	}
        int cnt = 0;
        ListNode countNode = head;
        while (countNode != null) {
        	++cnt;
        	countNode = countNode.next;
        }
        ListNode l1 = head;
        ListNode l2 = head;
        ListNode mid = null;
        boolean flag = (cnt % 2) == 1 ? true: false;
        cnt = cnt / 2;
    	while (cnt >  0) {
    		l1 = l1.next;
    		if (cnt == 1) {
    			mid = l1;
    			l1 = null;
    		}
    		--cnt;
    	}
        if (flag) {
        	l2 = mid.next;
        } else {
        	l2 = mid;
        }
        ListNode l3 = head;
        l2 = reverse(l2);
        return isEqual(l2, l3);
    }

    public ListNode reverse(ListNode node){
    	if (node == null || node.next == null) {
    		return node;
    	}    	
    	ListNode newNode = null;
    	while (node != null) {
    		ListNode nextNode = node.next;
    		node.next = newNode;
    		newNode = node;
    		node = nextNode;
    	}
    	return newNode;
    }

    public boolean isEqual(ListNode node1, ListNode node2){
    	while (node1 != null && node2 != null) {
    		if (node1.val != node2.val) {
    			return false;
    		}
    		node1 = node1.next;
    		node2 = node2.next;
    	}
    	return true;
    }

}
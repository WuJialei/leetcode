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
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode cur = null, pre = null;
        while(fast != null && fast.next != null) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur; 
        }
        ListNode p2 = slow.next;
        //ListNode tmp = slow;
        slow.next = pre;
        pre = slow;
        ListNode p1 = fast == null ? pre.next : pre;
        
        while(p2 != null) {
            if(p2.val != p1.val) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;
        
    }
        /*
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
    }*/

}

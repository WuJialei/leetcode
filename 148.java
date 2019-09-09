/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? null: mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}

    	ListNode p = head;
    	ListNode q = head;
    	ListNode tail = p;
    	while(q != null && q.next != null) {
    		tail = p;
    		p = p.next;
    		q = q.next.next;
    	}
    	tail.next = null;
    	ListNode left = mergeSort(head);
    	ListNode right = mergeSort(p);
    	return merge(left, right);
    }

    public ListNode merge(ListNode l, ListNode r) {
    	ListNode tmp = new ListNode(0);
    	ListNode ret = tmp;
    	while(l != null && r != null) {
    		if (l.val < r.val) {
    			tmp.next = l;
    			tmp = tmp.next;
    			l = l.next;
    		} else {
    			tmp.next = r;
    			tmp = tmp.next;
    			r = r.next;
    		}
    	}

    	while(l != null) {
    		tmp.next = l;
    		tmp = tmp.next;
    		l = l.next;
    	}

    	while (r != null) {
    		tmp.next = r;
    		tmp = tmp.next;
    		r = r.next;
    	}
    	return ret.next;

    }

}
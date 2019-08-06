/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
        	return null;
        }
        ListNode s1 = headA;
        ListNode s2 = headB;
        int cnt1 = 0, cnt2 = 0;
        while(s1 != s2){
        	if(cnt1 > 1 || cnt2 > 1){
        		return null;
        	}
        	if (s1.next==null) {
        		s1 = headB;
        		++cnt1;
        	}
        	else{
        		s1 = s1.next;
        	}
        	if (s2.next==null) {
        		s2 = headA;
        		++cnt2;
        	}
        	else{
        		s2 =s2.next;
        	}
        }
        return s1;
    }
}
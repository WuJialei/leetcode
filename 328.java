/* *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/* class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int cnt = 2;
        ListNode evenList = null;
        ListNode evenListIndex = null;
        ListNode ret = head;
        ListNode pre = head;
        ListNode oddList = head.next;
        while(oddList != null) {
            if(cnt % 2 == 0) {
                ListNode tmp = new ListNode(oddList.val);
                if (evenList == null) {
                    tmp.next = evenList;
                    evenList = tmp;
                    evenListIndex = evenList;
                } else {
                    evenList.next = tmp;
                    evenList = evenList.next;
                }
                pre.next = oddList.next;
                oddList = oddList.next;
            } else {
                pre = oddList;
                oddList = oddList.next;
            }
            ++cnt;
        }
        pre.next = evenListIndex;
        return ret;


        /* if (head == null || head.next == null) {
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
        return oddNodesResult; */
        
    }
}
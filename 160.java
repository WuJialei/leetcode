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
        /*
        if(headA == null || headB == null){
        	return null;
        }
        ListNode s1 = headA;
        ListNode s2 = headB;
        int cnt1 = 0, cnt2 = 0;
        while(s1 != null) {
            ++cnt1;
            s1 = s1.next;
        }
        
        while(s2 != null) {
            ++cnt2;
            s2 = s2.next;
        }
        
        int cnt = cnt1 - cnt2;
        if (cnt > 0) {
            while(cnt > 0) {
                headA = headA.next;
                --cnt;
            }
        } else if (cnt < 0) {
            while(cnt < 0) {
                headB = headB.next;
                ++cnt;
            }
        }
        while(headA != null && headB != null) {
            if (headA == headB) {
                return new ListNode(headA.val);
            }
            headA = headA.next;
            headB = headB.next;
        }  
        return null;
    }
    */
    
        /**
        定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

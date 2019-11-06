import java.util.*;
import javafx.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Pair<Integer, Integer>> stack = new Stack<Pair<Integer, Integer>>();
        int cnt = 0;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            ++len;
            p = p.next;
        }
        int[] ans = new int[len];
        while (head != null) {
            // 链表的每个元素入栈前先把比她小的元素解决直到碰到比他大的元素
            while (!stack.isEmpty() && head.val > stack.peek().getKey()) {
                ans[stack.peek().getValue()] = head.val;
                stack.pop();
            }
            // 链表的每一个元素都有入栈
            stack.push(new Pair<>(head.val, cnt++));
            head = head.next;
        }
        return ans;
    }
}
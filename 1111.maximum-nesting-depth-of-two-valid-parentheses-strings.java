import java.util.Stack;

/*
 * @lc app=leetcode id=1111 lang=java
 *
 * [1111] Maximum Nesting Depth of Two Valid Parentheses Strings
 */

// @lc code=start
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        int[] ans = new int[len];
        int depth = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; ++i) {
            if (seq.charAt(i) == '(') {
                stack.push(seq.charAt(i));
                ans[i] = stack.size();
                depth = Math.max(depth, stack.size());
            } else {
                ans[i] = stack.size();
                stack.pop();
            }
        }
        int val = depth/2;
        for (int i = 0; i < len; ++i) {
            if (ans[i] <= val) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
// @lc code=end


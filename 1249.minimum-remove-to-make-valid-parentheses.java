/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')'){
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        String ans = new String("");
        int end = s.length();
        while (!stack.isEmpty()) {
            int start = stack.pop();
            ans = s.substring(start+1, end) + ans;
            end = start;
        }
        ans = s.substring(0, end) + ans;
        return ans;
    }
}
// @lc code=end


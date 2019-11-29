/*
 * @lc app=leetcode id=1190 lang=java
 *
 * [1190] Reverse Substrings Between Each Pair of Parentheses
 */

// @lc code=start
class Solution {
    int[] location;
    public String reverseParentheses(String s) {
        StringBuilder ans = new StringBuilder("");
        location = new int[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int pre = stack.pop();
                location[pre] = i;
                location[i] = pre;
            }
        }
        reverse(s, false, 0, s.length()-1, ans);
        return ans.toString();
    }

    public void reverse(String s, boolean flag, int start, int end, StringBuilder sb) {
        if (flag) {
            for (int i = end; i >= start; --i) {
                if (s.charAt(i) == ')') {
                    reverse(s, false, location[i]+1, i-1, sb);
                    i = location[i];
                } else {
                    sb.append(s.charAt(i));
                }
            }
        } else {
            for (int i = start; i <= end; ++i) {
                if (s.charAt(i) == '(') {
                    reverse(s, true, i+1, location[i]-1, sb);
                    i = location[i];
                } else {
                    sb.append(s.charAt(i));
                }
            }
            
        }
    }

}
// @lc code=end


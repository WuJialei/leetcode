/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 */

// @lc code=start
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.size();
    }
}
// @lc code=end


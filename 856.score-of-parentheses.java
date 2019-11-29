/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                // 深度加1， 得分为0
                stack.push(0);
            } else {
                // 当前得分加倍，并将该得分加到上一层深度
                int cur = stack.pop();
                int last = stack.pop();
                stack.push(last + Math.max(1, 2 * cur));
            }
        }
        return stack.pop();
    }
}
// @lc code=end


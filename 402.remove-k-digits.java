/*
 * @lc app=leetcode id=402 lang=java
 *
 * [402] Remove K Digits
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder("");
        Stack<Character> stack = new Stack<Character>();
        if (num.length() == k) {
            return "0";
        }
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                --k;
            }
            stack.push(c);
        }
        boolean flag = false;
        for (int i = 0; i < stack.size() - k; ++i) {
            if (!flag && stack.get(i) != '0') {
                flag = true;
            }
            if (flag) {
                ans.append(stack.get(i));
            }
        }
        return ans.toString().equals("") ? "0" : ans.toString();
    }
}
// @lc code=end


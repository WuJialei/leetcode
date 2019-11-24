/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
            
        }
        for (char c : T.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
            
        }
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");
        while(!stack1.isEmpty()) {
            s1.append(stack1.pop());
        }
        while(!stack2.isEmpty()) {
            s2.append(stack2.pop());
        }
        return s1.toString().equals(s2.toString());
    }
}
// @lc code=end


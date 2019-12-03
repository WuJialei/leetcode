/*
 * @lc app=leetcode id=1003 lang=java
 *
 * [1003] Check If Word Is Valid After Substitutions
 */

// @lc code=start
class Solution {
    public boolean isValid(String S) {
        /*
        while (S.contains("abc")) {
            S = S.replace("abc", "");
        }
        return S.equals("");
        */
        Stack<Character> stack = new Stack<Character>();
        for (char c : S.toCharArray()) {
            // 如果有c则把前面出现b和a依次除去
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end


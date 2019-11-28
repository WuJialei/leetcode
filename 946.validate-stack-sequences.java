/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, j = 0;
        int len = pushed.length;
        for (; i <= len;) {
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                ++j;
            }
            if (i < len) {
                stack.push(pushed[i]);
            }
            ++i;
            
        }
        return j==len;
        
    }
}
// @lc code=end


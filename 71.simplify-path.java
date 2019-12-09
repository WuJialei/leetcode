/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < stack.size(); ++i) {
            sb.append("/" + stack.get(i));
        }
        return sb.toString();
    }
}
// @lc code=end


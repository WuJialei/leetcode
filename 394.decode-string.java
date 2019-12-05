/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {

    Stack<Integer> cntS = new Stack<Integer>();
    Stack<String> strS = new Stack<String>();
    StringBuilder ans = new StringBuilder("");

    public String decodeString(String s) {
        int num = 0;
        for(char c : s.toCharArray()) {
            if (c == '[') {
                cntS.push(num);
                num = 0;
                strS.push(ans.toString());
                ans = new StringBuilder("");
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder("");
                int cnt = cntS.pop();
                while (cnt > 0) {
                    tmp.append(ans.toString());
                    --cnt;
                }
                ans = new StringBuilder(strS.pop().toString() + tmp.toString());
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + Integer.parseInt(c+"");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 */

// @lc code=start
class Solution {


    private int len;
    private String str;

    public List<String> dfs(int index) {
        if (index >= len) {
            return null;
        }
        char cur = str.charAt(index);
        String[] curStr;
        if (cur >= '0' && cur <= '9') {
            curStr = new String[1];
            curStr[0] = "" + cur;
        } else {
            curStr = new String[2];
            curStr[0] = ("" + cur).toUpperCase();
            curStr[1] = ("" + cur).toLowerCase();
        }
        List<String> ans = new ArrayList<>();
        List<String> next = dfs(index+1);
        if (next == null) {
            for (int i = 0; i < curStr.length; ++i) {
                ans.add(curStr[i]);
            }
        } else {
            for (int i = 0; i < curStr.length; ++i) {
                for (String s : next) {
                    String tmp = curStr[i] + s;
                    ans.add(tmp);
                }
            }
        }
        return ans;
        
    }

    public List<String> letterCasePermutation(String S) {
        if (S == null || S.length() < 1) {
            return null;
        }
        len = S.length();
        str = S;
        return dfs(0);
    }
}
// @lc code=end


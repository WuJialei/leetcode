import java.util.ArrayList;

/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        /*
        int i = 0, j = 0;
        for (; i < t.length() && j < s.length(); ++i) {
            if (s.charAt(j) == t.charAt(i)) {
                ++j;
            }
        }
        return j == s.length();
        */
        List<Integer> lists[] = new ArrayList[26];
        for (int i = 0; i < 26; ++i) {
            lists[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < t.length(); ++i) {
            char c  = t.charAt(i);
            lists[c - 'a'].add(i);
        }
        int pre  = -1;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            int left = 0;
            int right = lists[c].size() - 1;
            while (left < right) {
                int mid = left + (right - left)/2;
                if (lists[c].get(mid) > pre) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (right < left || lists[c].get(left) <= pre) {
                return false;
            }
            pre = lists[c].get(left);
        }
        return true;
    }
}
// @lc code=end


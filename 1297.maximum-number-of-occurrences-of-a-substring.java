import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1297 lang=java
 *
 * [1297] Maximum Number of Occurrences of a Substring
 */

// @lc code=start
class Solution {

    private int letters;

    public boolean judge (String str) {
        HashSet<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
            if (set.size() > letters) {
                return false;
            }
        }
        return true;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s == null || s.length() < minSize) {
            return 0;
        }
        letters = maxLetters;
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - minSize; ++i) {
            String str = s.substring(i, i+minSize);
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
                ans = Math.max(ans, map.get(str));
            } else {
                if (judge(str)) {
                    map.put(str, 1);
                    ans = Math.max(ans, map.get(str));
                }
            }
        }
        return ans;
    }
}
// @lc code=end


import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=756 lang=java
 *
 * [756] Pyramid Transition Matrix
 */

// @lc code=start
class Solution {

    private List<String> allowed;

    public boolean dfs (HashSet<Character>[] lists, int cnt) {
        if (cnt < 1) {
            return true;
        }
        HashSet<Character>[] ans = new HashSet[cnt];
        for (int i = 0; i < cnt; ++i) {
            ans[i] = new HashSet<Character>();
            for (char a : lists[i]) {
                for (char b : lists[i+1]) {
                    String head = "" + a + b;
                    for (int j = 0; j < allowed.size(); ++j) {
                        if (allowed.get(j).startsWith(head) ) {
                            ans[i].add(allowed.get(j).charAt(2));
                        }
                    }
                }
            }
            if (ans[i].size() < 1) {
                return false;
            }
        }
        return dfs(ans, cnt - 1);
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom == null || bottom.length() < 1) {
            return false;
        }
        this.allowed = allowed;
        HashSet<Character>[] lists = new HashSet[bottom.length()];
        char[] chars = bottom.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            lists[i] = new HashSet<>();
            lists[i].add(chars[i]);
        }
        return dfs(lists, bottom.length() - 1);
    }
}
// @lc code=end


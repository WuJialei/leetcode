import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> t : list) {
            int cnt = t.getValue();
            while (cnt > 0) {
                ans.append(t.getKey());
                --cnt;
            }
        }
        return ans.toString();
    }
}
// @lc code=end


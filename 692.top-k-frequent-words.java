import java.util.HashMap;

/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, 
            (a, b) -> {
                if (a.getValue() == b.getValue()) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return b.getValue() - a.getValue();
                }
            }
        );
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < k; ++i) {
            ans.add(list.get(i).getKey());
        }
        return ans;
    }
}
// @lc code=end


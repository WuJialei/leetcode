import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {

    HashMap<String, List<String>> graph;

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<String, List<String>>();
        for (int i = 0; i < tickets.size(); ++i) {
            String src = tickets.get(i).get(0);
            String dst = tickets.get(i).get(1);
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<String>());
            }
            graph.get(src).add(dst);
        }
        for (String key : graph.keySet()) {
            Collections.sort(graph.get(key), (a, b) -> a.compareTo(b));
        }
        List<String> ans = new ArrayList<>();
        dfs("JFK", ans);
        return ans;

    }

    public void dfs (String src, List<String> list) {
        List<String> tmp = graph.get(src);
        while (tmp != null && tmp.size() > 0) {
            String next = tmp.remove(0);
            dfs(next, list);
        }
        list.add(0, src);
    }


}
// @lc code=end


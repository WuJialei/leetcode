import java.util.ArrayDeque;
import java.util.List;

/*
 * @lc app=leetcode id=802 lang=java
 *
 * [802] Find Eventual Safe States
 */

// @lc code=start
class Solution {

    int[][] g;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        g = graph;
        List<Integer> ans = new ArrayList<>();
        int len = graph.length;
        int[] visited = new int[len];
        // 从原点出发无环即可成为达到最终安全点的点
        for (int i = 0; i < len; ++i) {
            if (dfs(i, visited)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs (int src, int[] visited) {
        if (visited[src] > 0) {
            return visited[src] == 2;
        }
        visited[src] = 1;
        for (int nei : g[src]) {
            if (visited[nei] == 1 || !dfs(nei, visited)) {
                return false;
            }
        }
        visited[src] = 2;
        return true;
    }

}
// @lc code=end


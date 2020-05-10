/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {

    private int[][] graph;
    private int n;
    private boolean[] visited;

    public void dfs (int index) {
        for (int next = 0; next < n; ++next) {
            if (graph[index][next] == 1 && !visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length < 1 || M[0].length < 1) {
            return 0;
        }
        graph = M;
        n = graph.length;
        int ans = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; ++i) {            
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                ++ans;
            }
        }
        return ans;

    }
}
// @lc code=end


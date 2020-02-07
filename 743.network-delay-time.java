/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {

    int[][] graph;
    int[] dist; 
    boolean[] visited;

    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        visited[K] = true;
        // 源点到目的点的距离数组
        dist = new int[N+1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                graph[i][j] = i == j ? 0 : 6005;
            } 
        }
        for (int i = 0; i < times.length; ++i) {
            int x = times[i][0];
            int y = times[i][1];
            int val = times[i][2];
            if (graph[x][y] > val) {
                graph[x][y] = val;
            }
        }
        for (int i = 1; i <= N; ++i) {
            dist[i] = graph[K][i];
        }

        int iteration = 1;
        while (iteration < N) {
            // 找从源点出发到未访问过的距离最小的点
            int minDist = 6005;
            int index = 0;
            for (int i = 1; i <= N; ++i) {
                if (!visited[i] && minDist > dist[i]) {
                    minDist = dist[i];
                    index = i;
                }
            }
            visited[index] = true;
            if (minDist >= 6005) {
                return -1;
            }
            // 更新最小距离
            for (int i = 1; i <= N; ++i) {
                if (!visited[i] && dist[i] > graph[index][i] + dist[index]) {
                    dist[i] = graph[index][i] + dist[index];
                }
            }
            ++iteration;
        }
        int ans = 0;
        for (int i = 1; i <= N; ++i) {
            ans = Math.max(ans, dist[i]);
        }
        return ans>=6005 ? -1 : ans;
    }
}
// @lc code=end


/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        /*
        int[][] temp1 = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int[][] temp2 = flights;
        if(Arrays.equals(temp1, temp2)) {
            return 7;
        }
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j){
                graph[i][j] = i == j ? 0 : -1;
            }
        }
        for (int i = 0; i < flights.length; ++i) {
            int x = flights[i][0];
            int y = flights[i][1];
            int val = flights[i][2];
            graph[x][y] = val;
        }
        int[] dest = new int[n];
        int[] stops = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            dest[i] = graph[src][i];
        }
        visited[src] = true;
        int cnt = n - 1;
        while (cnt > 0) {
            int minVal = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < n; ++i) {
                if (!visited[i] &&  dest[i] != -1 && minVal > dest[i] && stops[i] <= K) {
                    index = i;
                    minVal = dest[i];
                }
            }
            if (index == -1) {
                break;
            } else {
                visited[index] = true;
                for (int i = 0; i < n; ++i) {
                    if (!visited[i] && graph[index][i] != -1) {
                        if (i != dst && stops[index]+1 < K) {
                            if (dest[i] == -1 || dest[i] > dest[index] + graph[index][i]) {
                                dest[i] = dest[index] + graph[index][i];
                                stops[i] = stops[index] + 1;
                            }
                        } else if (i == dst && stops[index] < K) {
                            if (dest[i] == -1 || dest[i] > dest[index] + graph[index][i]) {
                                dest[i] = dest[index] + graph[index][i];
                                stops[i] = stops[index] + 1;
                            }
                        }
                        
                    }
                }
            }
            --cnt;
        }
        
        return dest[dst];
        */
        int[][] dist = new int[2][n];
        Arrays.fill(dist[0], Integer.MAX_VALUE/2);
        Arrays.fill(dist[1], Integer.MAX_VALUE/2);
        dist[0][src] = dist[1][src] = 0;
        for (int i = 0; i <= K; ++i) {
            for (int[] edge : flights) {
                dist[i&1][edge[1]] = Math.min(dist[i&1][edge[1]], dist[(i+1)&1][edge[0]] + edge[2]);
            }
        }
        return dist[K&1][dst] < Integer.MAX_VALUE/2 ? dist[K&1][dst] : -1;
    }
}
// @lc code=end


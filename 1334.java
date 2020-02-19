import java.util.HashMap;

class Solution {

    int[][] ans;
    HashMap<Integer, HashMap<Integer, Integer>> graph;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ans = new int[n][2];
        graph = new HashMap<Integer, HashMap<Integer, Integer>>();
        for (int i = 0; i < n; ++i) {
            graph.put(i, new HashMap<Integer, Integer>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int x = edges[i][0];
            int y = edges[i][1];
            int val = edges[i][2];
            graph.get(x).put(y, val);
            graph.get(y).put(x, val);
        }
        for (int i = 0; i < n; ++i) {
            boolean[] visited = new boolean[n];
            ans[i][1] = dfs(i, i, visited, distanceThreshold);
        }
        int minCity = n;
        for (int i = 0; i < n; ++i) {
            System.out.println(i0 + ": " + ans[i][0]);
            System.out.println(i1 + ": " + ans[i][1]);
            if (ans[i][0] > 1) {
                minCity = Math.min(minCity, ans[i][0]);
            }
        }
        int c = 0;
        int v = -1;
        for (int i = 0; i < n; ++i) {
            if (ans[i][0] == minCity) {
                if (ans[i][1] >= v) {
                    c = i;
                }
            }
        }
        return c;


    }

    public int dfs (int src, int cur, boolean[] vis, int len) {
        if (vis[cur] || len <= 0) {
            return 0;
        }
        int ret = 0;
        vis[cur] = true;
        ++ans[src][0];
        for (int nei : graph.get(cur).keySet()) {
            if (!vis[nei] && graph.get(cur).get(nei) <= len) {
                // ++ans[src][0];
                // vis[nei] = true;
                int curLen = graph.get(cur).get(nei);
                int nextLen = dfs(src, nei, vis, len - curLen);
                ret = Math.max(ret, curLen + nextLen);
            }
        }
        return ret;
    }

}
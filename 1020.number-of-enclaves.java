/*
 * @lc app=leetcode id=1020 lang=java
 *
 * [1020] Number of Enclaves
 */

// @lc code=start
class Solution {

    private int[][] graph;
    private int m;
    private int n;
    private int ans;
    private boolean[][] visited;
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    public int dfs (int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return -1;
        }
        if (graph[x][y] == 0 || visited[x][y]) {
            return 0;
        }
        int ret = 0;
        int cnt = 1;
        visited[x][y] = true;
        for (int i = 0; i < dx.length; ++i) {
            int next = dfs(x + dx[i], y + dy[i]);
            if (next == -1) {
                ret = -1;
            } else {
                cnt += next;
            }
        }
        return ret == -1 ? ret : cnt;
    }

    public int numEnclaves(int[][] A) {
        if (A == null || A.length < 1 || A[0].length < 1) {
            return 0;
        }
        graph = A;
        m = A.length;
        n = A[0].length;
        ans = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    int tmp = dfs(i, j);
                    ans += tmp < 0 ? 0 : tmp;
                }
            }
        }
        return ans;
    }
}
// @lc code=end


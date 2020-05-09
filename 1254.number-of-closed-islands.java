/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution {

    private int m;
    private int n;
    private int[][] grid;
    private boolean[][] visited;

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public int dfs (int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return 1;
        }
        if (visited[x][y] || grid[x][y] == 1) {
            return 2;
        }
        visited[x][y] = true;
        int ret = 2;
        for (int i = 0; i < dx.length; ++i) {
            if (dfs(x + dx[i], y + dy[i]) < 2) {
                ret = 1;
            }
        }
        return ret;
    }

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int ans = 0;
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    if (dfs(i, j) == 2) {
                        ++ans;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end


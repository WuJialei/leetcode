/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {

    private boolean[][] visited;
    private int m;
    private int n;
    private int[][] grid;
    private int dx[] = {-1, 1, 0, 0};
    private int dy[] = {0, 0, -1, 1};

    public int dfs (int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        int ret = 1;
        for (int i = 0; i < dx.length; ++i) {
            ret += dfs(x + dx[i], y + dy[i]);
        }
        return ret;
    }

    public int maxAreaOfIsland(int[][] grid) {
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
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans = Math.max(ans, dfs(i, j));
                }
            }
        }
        return ans;
    }
}
// @lc code=end


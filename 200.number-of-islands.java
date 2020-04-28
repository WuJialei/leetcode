/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {

    private char[][] g;
    private boolean[][] visited;
    private int m;
    private int n;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    public void dfs (int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] == '0' || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int d = 0; d < dx.length; ++d) {
            dfs(x + dx[d], y + dy[d]) ;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        g = grid;
        m = grid.length;
        n = grid[0].length; 
        visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g[i][j] == '1' && !visited[i][j]) {
                    ++ans;
                    dfs(i, j);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


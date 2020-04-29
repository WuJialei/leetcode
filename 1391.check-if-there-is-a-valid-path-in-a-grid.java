/*
 * @lc app=leetcode id=1391 lang=java
 *
 * [1391] Check if There is a Valid Path in a Grid
 */

// @lc code=start
class Solution {

    private int[][] streets = {
        {-1, 1, -1, 1},
        {1, -1, 1, -1},
        {-1, -1,1, 1},
        {-1, 1, 1, -1},
        {1, -1, -1, 1},
        {1, 1, -1, -1}
    };

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    private int[][] g;
    private int m;
    private int n;
    private boolean[][] visited;

    public boolean dfs (int i, int j, int dir) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return false;
        }
        if (streets[g[i][j]-1][(dir + 2)%4] == -1) {
            return false;
        }
        if (i == m-1 && j == n-1) {
            return true;
        }
        int t = 0;
        for (; t < dx.length; ++t) {
            if ((streets[g[i][j]-1][t] > -1) && (t != (dir+2)%4)) {
                break;
            }
        }
        visited[i][j] = true;
        boolean ret = dfs(i + dx[t], j + dy[t], t);
        visited[i][j] = false;
        return ret;
    }

    public boolean hasValidPath(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        boolean ans = false;
        int start = g[0][0];
        if (m == 1 && n == 1) {
            return true;
        }
        visited = new boolean[m][n];
        visited[0][0] = true;
        for (int i = 0; i < dx.length; ++i) {
            if (streets[start-1][i] > -1) {
                if (dfs(dx[i], dy[i], i)){
                    return true;
                }
            }
        }
        return ans;
    }
}
// @lc code=end


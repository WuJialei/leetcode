/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {

    private int[][] g;
    private int color;
    private int m;
    private int n;
    private boolean[][] visited;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int origin;

    public void dfs (int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || g[x][y] != origin) {
            return;
        }
        visited[x][y] = true;
        g[x][y] = color;
        for (int i = 0; i < dx.length; ++i) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length < 1 || image[0].length < 1) {
            return image;
        }
        g = image;
        color = newColor;
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        origin = g[sr][sc];
        dfs(sr, sc);
        return g;
    }
}
// @lc code=end


import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {

    private int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return -1;
        }
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0][0] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int cnt = queue.size();
            while (cnt > 0) {
                int cur = queue.poll();
                if (cur == n*n - 1) {
                    return ans;
                }
                int x = cur / n;
                int y = cur % n;
                for (int i = 0; i < dx.length; ++i) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= n || yy < 0 || yy >= n || visited[xx][yy] || grid[xx][yy] == 1) {
                        continue;
                    }
                    visited[xx][yy] = true;
                    queue.offer(xx*n + yy);
                }
                --cnt;
            }
        }
        return -1;

    }
}
// @lc code=end


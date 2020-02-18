import java.util.Queue;

/*
 * @lc app=leetcode id=1162 lang=java
 *
 * [1162] As Far from Land as Possible
 */

// @lc code=start
class Solution {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0 || queue.size() == n*m) {
            return -1;
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] t = queue.poll();
                for (int i = 0; i < directions.length; ++i) {
                    int x = t[0] + directions[i][0];
                    int y = t[1] + directions[i][1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
                --size;
            }
            ++ans;
        }
        return ans-1;
    }
}
// @lc code=end


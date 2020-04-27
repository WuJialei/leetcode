import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {

    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1 && grid[0][0] == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    set.add(i*n + j);
                } else if (grid[i][j] == 2) {
                    queue.offer(i*n + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>();
            ++ans;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int x = cur / n;
                int y = cur % n;
                for (int i = 0; i < dx.length; ++i) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || grid[xx][yy] != 1) {
                        continue;
                    }
                    set.remove(xx*n + yy);
                    grid[xx][yy] = 2;
                    temp.offer(xx*n + yy);
                }
            }
            queue.addAll(temp);
        }
        return set.size() > 0 ? -1 : ans-1;


    }
}
// @lc code=end


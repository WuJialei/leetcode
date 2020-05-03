import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0 ,0, -1, 1};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return matrix;
        }
        int[][] array = matrix;
        int m = array.length;
        int n = array[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (array[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(i*n + j);
                }
            }
        }
        int size = 0;
        while (!queue.isEmpty()) {
            ++size;
            int cnt = queue.size();
            while (cnt > 0) {
                int cur = queue.poll();
                int x = cur / n;
                int y = cur % n;
                for (int i = 0; i < dx.length; ++i) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || visited[xx][yy]) {
                        continue;
                    }
                    if (array[xx][yy] == 1) {
                        array[xx][yy] = size;
                        visited[xx][yy] = true;
                        queue.offer(xx*n + yy);
                    }
                    
                }
                --cnt;
            }
        }
        return array;
    }
}
// @lc code=end


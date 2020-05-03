import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {

    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        boolean[][] vis1 = new boolean[m][n];
        boolean[][] vis2 = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            vis1[i][0] = true;
            vis2[i][n-1] = true;
            queue1.offer(i*n);
            queue2.offer(i*n + n-1);
        }
        for (int j = 1; j < n; ++j) {
            vis1[0][j] = true;
            vis2[m-1][n-1-j] = true;
            queue1.offer(j);
            queue2.offer((m-1)*n + n-1-j);
        }
        while (!queue1.isEmpty()) {
            int cnt = queue1.size();
            while (cnt > 0) {
                int cur = queue1.poll();
                int x = cur / n;
                int y = cur % n;
                for (int i = 0; i < dx.length; ++i) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || vis1[xx][yy]) {
                        continue;
                    }
                    if (matrix[xx][yy] >= matrix[x][y]) {
                        vis1[xx][yy] = true;
                        queue1.offer(xx*n + yy);  
                    }                 
                }
                --cnt;
            }
        }
        while (!queue2.isEmpty()) {
            int cnt = queue2.size();
            while (cnt > 0) {
                int cur = queue2.poll();
                int x = cur / n;
                int y = cur % n;
                for (int i = 0; i < dx.length; ++i) {
                    int xx = x + dx[i];
                    int yy = y + dy[i];
                    if (xx < 0 || xx >= m || yy < 0 || yy >= n || vis2[xx][yy]) {
                        continue;
                    }
                    if (matrix[xx][yy] >= matrix[x][y]) {
                        vis2[xx][yy] = true;
                        queue2.offer(xx*n + yy);  
                    }
                                      
                }
                --cnt;
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (vis1[i][j] && vis2[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


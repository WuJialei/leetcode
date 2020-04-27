import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {

    private int[][] arrays;
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int m;
    private int n;
    Queue<Integer> queue;

    public void dfs (int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || arrays[i][j] == 2 || arrays[i][j] == 0) {
            return;
        }
        arrays[i][j] = 2;
        queue.offer(i*n +j);
        for (int t = 0; t < dx.length; ++t) {
            dfs(i + dx[t], j + dy[t]);
        }

    }

    public int shortestBridge(int[][] A) {
        arrays = A;
        m = A.length;
        n = A[0].length;
        int x = 0, y = 0;
        boolean flag = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (A[i][j] == 1) {
                    x = i;
                    y = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        queue = new LinkedList();
        
        dfs(x, y);
        int min = 0;
        boolean[][] vis = new boolean[m][n];
        boolean go = false;
        while (!queue.isEmpty()) {
            ++min;
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int c = cur / n;
                int d = cur % n;
                for (int t = 0; t < dx.length; ++t) {
                    int cc = c + dx[t];
                    int dd = d + dy[t];
                    if (cc < 0 || cc >= m || dd < 0 || dd >= n || vis[cc][dd] || arrays[cc][dd] == 2) {
                        continue;
                    }
                    if (arrays[cc][dd] == 1) {
                        go = true;
                        break;
                    }
                    if (arrays[cc][dd] == 0) {
                        vis[cc][dd] = true;
                        temp.offer(cc*n + dd);
                    }
                    
                }
            }
            if (go) {
                break;
            } else {
                queue.addAll(temp);
            }
            
        }
        return min - 1;
    }
}
// @lc code=end


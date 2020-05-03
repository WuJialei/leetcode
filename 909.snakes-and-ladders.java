import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start
class Solution {

    private int n;


    public int val2board(int target) {
        /*
        int x = n - 1 - (target-1)/n;
        int y = (x % 2 == 0) ? (n-1) - (target-1)%n: (target-1)%n;
        return x * n + y;
        */
        
        int quot = (target-1) / n;
        int rem = (target-1) % n;
        int row = n - 1 - quot;
        int col = row % 2 != n % 2 ? rem : n - 1 - rem;
        return row * n + col;
        
    }

    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return -1;
        }
        int ans = 0;
        n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n*n+1];
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            ++ans;
            int cnt = queue.size();
            while (cnt > 0) {
                int cur = queue.poll();
                if (cur == n*n) {
                    return ans-1;
                }
                for (int next = cur + 1; next <= Math.min(n*n, cur + 6); ++next) {
                    if (!visited[next]) {
                        visited[next] = true;
                        int val = val2board(next);
                        int x = val / n;
                        int y = val % n;
                        queue.offer(board[x][y]==-1 ? next : board[x][y]);

                    }                
                }                
                --cnt;
            }
        }
        return -1;
    }


}
// @lc code=end


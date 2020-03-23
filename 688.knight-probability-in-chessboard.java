/*
 * @lc app=leetcode id=688 lang=java
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
class Solution {

    int[][] directions = {{1, 2}, {2, 1},{2, -1}, {1, -2},{-1, 2}, {-2, 1},{-2, -1}, {-1, -2}};
    double[][] board;
    int n;

    public boolean judge (int x, int y) {
        if (x < 1 || x > n || y < 1 || y > n) {
            return false;
        }
        return true;
    }

    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0) {
            return (double)1;
        }
        n = N;
        int k = K;
        double[][] dp = new double[2][(n+1)*(n+1)];
        // dp[i,j,k]表示坐标i，j迭代k次在盘内的概率
        // dp[i,j,k] = sum(dp[ii,jj,k-1]/8.0), ii, jj为i,j的下一步范围内坐标
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                double temp = 0;
                for (int cnt = 0; cnt < directions.length; ++cnt) {
                    if (judge(i+directions[cnt][0], j + directions[cnt][1])) {
                        temp += 1.0/8;
                    }
                }
                dp[1][i*(n+1) + j] = temp;
            }
        }
        for (int t = 2; t <= k; ++t) {
            int index = t & 1;
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    double temp = 0;
                    for (int cnt = 0; cnt < directions.length; ++cnt) {
                        if (judge(i+directions[cnt][0], j + directions[cnt][1])) {
                            int ii = i+directions[cnt][0];
                            int jj = j + directions[cnt][1];
                            temp += dp[1-index][ii*(n+1) + jj]/8;
                        }
                    }
                    dp[index][i*(n+1) + j] = temp;
                }
            }
        }
        return dp[k&1][(r+1)*(n+1) + c +1];
        /*
        board = new double[N+1][N+1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                double temp = 0;
                for (int cnt = 0; cnt < directions.length; ++cnt) {
                    if (judge(i+directions[cnt][0], j + directions[cnt][1])) {
                        temp += 1.0/8;
                    }
                }
                board[i][j] = temp;
            }
        }
        double ans = 0;
        ans = dfs(r+1, c+1, K);
        return ans;
        */
    }

    public double dfs (int x, int y, int k) {
        if (k == 1) {
            return board[x][y];
        }
        double ret = 0;
        for (int i = 0; i < directions.length; ++i) {
            if (judge(x+directions[i][0], y+directions[i][1])) {
                ret += 1.0/8 * dfs(x+directions[i][0], y+directions[i][1], k-1);
            }
        }
        return ret;
    }

}
// @lc code=end


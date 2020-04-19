class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sums = new int[m+1][n+1];
        // sums[0][0] = mat[0][0];
        // for (int i = 1; i < m; ++i) {
        //     sums[i][0] = sums[i-1][0] + mat[i][0];
        // }
        // for (int j = 1; j < n; ++j) {
        //     sums[0][j] = sums[0][j-1] + mat[0][j];
        // }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] + mat[i-1][j-1] - sums[i-1][j-1];
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (ans >= m || ans >= n) {
                    return ans;
                }
                if (mat[i-1][j-1] <= threshold) {
                    ans = Math.max(ans, 1);
                }
                int len = ans + 1;
                while ((i - len >= 0) && (j - len >= 0)) {
                    int ii = i - len;
                    int jj = j - len;
                    int sum = sums[i][j] - sums[i][jj] - sums[ii][j] + sums[ii][jj];
                    if (sum > threshold) {
                        break;
                    } else {
                        ++len;
                    }
                }
                ans = Math.max(ans, len - 1);
            }
        }
        return ans;
    }
}
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sums = new int[m+1][n+1];
        int ans = 0;
        int th = Math.min(m, n);
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sums[i][j] = matrix[i-1][j-1] + sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1];
                for (int t = 1; t <= th; ++t) {
                    int x0 = Math.max(i-t, 0);
                    int y0 = Math.max(j-t, 0);
                    if (sums[i][j] - sums[x0][j] - sums[i][y0] + sums[x0][y0] != t*t) {
                        break;
                    }
                    ++ans;
                }
            }
        }
        /*
        int ans = 0;
        int th = Math.min(m, n);
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int t = 1; t <= th; ++t) {
                    int x0 = Math.max(i-t, 0);
                    int y0 = Math.max(j-t, 0);
                    if (sums[i][j] - sums[x0][j] - sums[i][y0] + sums[x0][y0] != t*t) {
                        break;
                    }
                    ++ans;
                }
            }
        }
        */
        return ans;
    }
}
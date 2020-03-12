class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] sums = new int[m+1][n+1];
        int[][] ans = new int[m][n];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int k = K;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int x1 = Math.min(i+k+1, m);
                int y1 = Math.min(j+k+1, n);
                int x0 = Math.max(i-k, 0);
                int y0 = Math.max(j-k, 0);
                ans[i][j] = sums[x1][y1] + sums[x0][y0] - sums[x1][y0] - sums[x0][y1];
            }
        }
        return ans;
    }
}
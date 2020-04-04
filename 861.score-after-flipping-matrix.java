/*
 * @lc app=leetcode id=861 lang=java
 *
 * [861] Score After Flipping Matrix
 */

// @lc code=start
class Solution {

    int[][] matrix;
    int m;
    int n;

    public void rowChange(int i) {
        for (int j = 0; j < n; ++j) {
            matrix[i][j] = 1 - matrix[i][j];
        }
    }

    public void colChange(int j) {
        for (int i = 0; i < m; ++i) {
            matrix[i][j] = 1 - matrix[i][j];
        }
    }

    public int matrixScore(int[][] A) {
        matrix = A;
        m = A.length;
        n = A[0].length;
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] != 1) {
                rowChange(i);
            }
        }
        int ans = 0;
        ans += m * Math.pow(2, n-1);
        for (int j = 1; j < n; ++j) {
            int cnt1 = 0;
            for (int i = 0; i < m; ++i) {
                cnt1 += matrix[i][j];
            }
            cnt1 = Math.max(cnt1, m-cnt1);
            ans += cnt1 * Math.pow(2, n-1-j);
        }
        return ans;
    }
}
// @lc code=end


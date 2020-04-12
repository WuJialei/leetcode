class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            if (grid[i][n-1] >= 0) {
                continue;
            }
            if (grid[i][0] < 0) {
                cnt += n;
                continue;
            }
            int left = 0;
            int right = n - 1;
            // 找第一个小于0的位置
            while (left < right) {
                int mid = left + (right - left)/2;
                if (grid[i][mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (grid[i][left] < 0) {
                cnt += n - left;
            }
        }
        return cnt;
    }
}
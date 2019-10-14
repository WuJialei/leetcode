class Solution {

    private int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private boolean[][] flag;
    private int[][] path;
    private int ans;

    public int dfs (int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        int temp = 1;
        flag[i][j] = true;
        for (int a = 0; a < dir.length; ++a) {
            int ii = i + dir[a][0];
            int jj = j + dir[a][1];
            if (ii < 0 || jj < 0 || ii >= matrix.length || jj >= matrix[0].length || flag[ii][jj]) {
                continue;
            } else if (matrix[ii][jj] > matrix[i][j]) {
                if (path[ii][jj] != 0) {
                    temp = Math.max(path[ii][jj] + 1, temp);
                } else {
                    path[ii][jj] = dfs(matrix, ii, jj);
                    temp = Math.max(path[ii][jj] + 1, temp);
                }                                
            }
        }
        path[i][j] = temp;
        flag[i][j] = false;
        return temp;
    }


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        flag = new boolean[n][m];
        path = new int[n][m];
        ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (path[i][j] == 0) {           
                    path[i][j] = dfs(matrix, i, j);
                    ans = Math.max(path[i][j], ans);
                }
            }
        }
        return ans;

    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] temp = new int[m][2];
        for (int i = 0; i < m; ++i) {
            int cnt = 0;
            if (mat[i][0] < 1) {
                cnt = 0;
            } else if (mat[i][n-1] > 0) {
                cnt = n;
            } else {
                int left = 0;
                int right = n-1;
                while (left < right) {
                    int mid = left + (right - left)/2;
                    if (mat[i][mid] > 0) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                cnt = left;
            }
            temp[i][0] = i;
            temp[i][1] = cnt;
        }
        Arrays.sort(
            temp,
            (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        );
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = temp[i][0];
        }
        return ans;
    }
}
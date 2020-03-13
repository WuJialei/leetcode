class Solution {

    public class Pair {
        int fir;
        int sec;
        public Pair (int a, int b) {
            fir = a;
            sec = b;
        }
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair[] dp = new Pair[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = new Pair(piles[i], 0);
        }
        for (int l = 1; l < n; ++l) {
            int j = l;
            for (int i = 0; i < n - l; ++i) {
                int left = piles[i] + dp[i+1].sec;
                int right = piles[j] + dp[i].sec;
                int temp = dp[i].fir;
                dp[i].fir = Math.max(left, right);
                dp[i].sec = left > right ? dp[i+1].fir: temp;
                ++j;
            }

        }
        return dp[0].fir > dp[0].sec;
        /*
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[i][j] = new Pair(0, 0);
                if (i == j) {
                    dp[i][j].fir = piles[i];
                }
            }
        }
        for (int l = 1; l < n; ++l) {
            int j = l;
            for (int i = 0; i < n - l; ++i) {
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                dp[i][j].fir = Math.max(left, right);
                dp[i][j].sec = left > right ? dp[i+1][j].fir: dp[i][j-1].fir;
                ++j;
            }
        }
        return dp[0][n-1].fir > dp[0][n-1].sec;
        */
    }
}

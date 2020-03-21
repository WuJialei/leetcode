import java.util.Arrays;

/*
 * @lc app=leetcode id=1024 lang=java
 *
 * [1024] Video Stitching
 */

// @lc code=start
class Solution {

    public class Line {
        int left;
        int right;
        public Line (int a, int b) {
            left = a;
            right = b;
        }
    }

    public int videoStitching(int[][] clips, int T) {
        int n = clips.length;
        int maxVal = 100_000_0000;
        Line[] lines = new Line[n];
        for (int i = 0; i < n; ++i) {
            lines[i] = new Line(clips[i][0], clips[i][1]);
        }
        Arrays.sort(
            lines,
            (a, b) -> {
                if (a.left == b.left) {
                    return a.right - b.right;
                } else {
                    return a.left - b.left;
                }
            }
        );
        int[] dp = new int[T+1];
        Arrays.fill(dp, maxVal);
        dp[0] = 0;
        // dp[i] 表示到达i的最少段数
        for (int i = 1; i <= T; ++i) {
            for (Line line : lines) {
                if (i < line.left) {
                    break;
                }
                if (i > line.left && i <= line.right) {
                    dp[i] = Math.min(dp[i], dp[line.left] + 1);
                }
            }
        }
        return dp[T] == maxVal ? -1 : dp[T];
    }
}
// @lc code=end


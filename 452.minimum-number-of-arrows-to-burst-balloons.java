/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {

    public class Point {
        int left;
        int right;
        public Point (int x, int y) {
            left = x;
            right = y;
        }
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        Arrays.sort(
            points,
            (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        );
        int left = points[0][0];
        int cnt = 1;
        for (int i = 1; i < points.length; ++i) {
            if (left <= points[i][1]) {
                left = Math.max(left, points[i][0]);
            } else {
                ++cnt;
                left = points[i][0];
            }
        }
        return cnt;
        // Point[] ps = new Point[points.length];
        // for (int i = 0; i < points.length; ++i) {
        //     ps[i] = new Point(points[i][0], points[i][1]);
        // }
        // Arrays.sort(
        //     ps,
        //     (a, b) -> {
        //         if (a.right == b.right) {
        //             return a.left - b.left;
        //         } else {
        //             return b.right - a.right;
        //         }
        //     }
        // );
        // int cnt = 1;
        // int left = ps[0].left;
        // for (int i = 1; i < ps.length; ++i) {
        //     if (left <= ps[i].right) {
        //         left = Math.max(left, ps[i].left);
        //     } else {
        //         ++cnt;
        //         left = ps[i].left;
        //     }
        // }
        // return cnt;
    }
}
// @lc code=end


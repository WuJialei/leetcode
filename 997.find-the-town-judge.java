/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 */

// @lc code=start
class Solution {

    public class Point{
        int in;
        int out;
    }

    public int findJudge(int N, int[][] trust) {
        Point[] points = new Point[N+1];
        for (int i = 0; i <= N; ++i) {
            points[i] = new Point();
        }
        for (int i = 0; i < trust.length; ++i) {
            ++points[trust[i][0]].out;
            ++points[trust[i][1]].in;
        }
        int cnt = 0;
        int index = 0;
        for (int i = 1; i <= N; ++i) {
            if (points[i].in == N-1 && points[i].out == 0) {
                ++cnt;
                index = i;
            }
        }
        if (cnt == 1) {
            return index;
        } else {
            return -1;
        }
        /*
        boolean[][] graph = new boolean[N+1][N+1];
        for (int i = 0; i < trust.length; ++i) {
            int y = trust[i][0];
            int x = trust[i][1];
            graph[x][y] = true;
        }
        int index = 0;
        int cnt = 0;
        for (int i = 1; i <= N; ++i) {
            boolean flag = true;
            for (int j = 1; j <= N; ++j) {
                if (i != j) {
                    flag &= graph[i][j];
                }                
            }
            if (flag) {
                ++cnt;
                index = i;
            }
        }
        if (cnt != 1) {
            return -1;
        } else {
            boolean flag = false;
            for (int i = 1; i <= N; ++i) {
                flag |= graph[i][index];
            }
            if (flag) {
                return -1;
            } else {
                return index;
            }
        }
        */
    }
}
// @lc code=end


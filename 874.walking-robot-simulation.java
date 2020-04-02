import java.util.HashSet;

/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {

    public static final int val = 70010;

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        int dir = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add((obstacle[0] + 30000)*val + obstacle[1] + 30000);
        }
        // 涉及到正负数范围二维数据压缩为一维数据
        // 设计单位坐标系通过取模来实现左转右转
        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int cnt = 1; cnt <= command; ++cnt) {                    
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];
                    if (set.contains((nextX + 30000)*val + nextY + 30000)) {    
                        ans = Math.max(ans, x*x + y*y);                    
                        break;
                    } else {
                        x = nextX;
                        y = nextY;
                        ans = Math.max(ans, x*x + y*y);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end


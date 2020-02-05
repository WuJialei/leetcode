import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {

    public int squre (int a, int b) {
        return a * a + b * b;
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, (o2, o1) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);

        for (int i = 0; i < points.length; ++i) {
            if (queue.size() < K) {
                queue.offer(points[i]);
            } else if (squre(points[i][0], points[i][1]) < squre(queue.peek()[0], queue.peek()[1])) {
                queue.poll();
                queue.offer(points[i]);
            }
        }
        int[][] ans = new int[K][2];
        int cnt = 0;
        while(!queue.isEmpty()) {
            ans[cnt] = queue.poll();
            ++cnt;
        }
        return ans;
    }
}
// @lc code=end


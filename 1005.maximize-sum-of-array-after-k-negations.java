import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1005 lang=java
 *
 * [1005] Maximize Sum Of Array After K Negations
 */

// @lc code=start
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (a, b) -> a - b
        );
        int sum = 0;
        for (int a : A) {
            sum += a;
            queue.offer(a);
        }
        while (K > 0) {
            if (queue.peek() == 0) {
                break;
            } else {
                int temp = queue.poll();
                sum -= temp;
                sum += -temp;
                queue.offer(-temp);
            }
            --K;
        }
        return sum;
    }
}
// @lc code=end


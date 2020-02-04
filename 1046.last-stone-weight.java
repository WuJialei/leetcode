import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            }
        );
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a-b);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        } else {
            return queue.peek();
        }
    }
}
// @lc code=end


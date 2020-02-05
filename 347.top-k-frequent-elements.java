import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.apple.concurrent.Dispatch.Priority;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {

    HashMap<Integer, Integer> map;

    public List<Integer> topKFrequent(int[] nums, int k) {
        map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,
            new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b){
                    return map.get(a) - map.get(b);
                }
            }
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else if (entry.getValue() > map.get(queue.peek())) {
                queue.poll();
                queue.offer(entry.getKey());
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
            ans.add(queue.poll());
        }       
        return ans;

    }
}
// @lc code=end


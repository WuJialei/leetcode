import java.util.HashMap;

/*
 * @lc app=leetcode id=659 lang=java
 *
 * [659] Split Array into Consecutive Subsequences
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] nums) {
        // 还有多少个的map
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        // 以x结尾的个数统计的map
        HashMap<Integer, Integer> end = new HashMap<Integer, Integer>();
        for (int num : nums) {
            left.put(num, left.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if(left.get(num) == 0) {
                continue;
            }
            left.put(num, left.get(num) - 1);
            if (end.getOrDefault(num-1, 0) > 0) {
                // 塞到前一个队列
                end.put(num-1, end.get(num-1)-1);
                end.put(num, end.getOrDefault(num, 0)+1);
            } else if (left.getOrDefault(num+1, 0) > 0 && left.getOrDefault(num+2, 0) > 0) {
                // 建新的队列
                left.put(num+1, left.get(num+1)-1);
                left.put(num+2, left.get(num+2)-1);
                end.put(num+2, end.getOrDefault(num+2, 0)+1);
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end


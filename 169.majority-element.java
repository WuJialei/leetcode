import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int index = -1;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            if (cnt < map.get(num)) {
                index = num;
                cnt = map.get(num);
            }
        }
        return index;
        /*
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int index = nums.length/2 + 1;
        Arrays.sort(nums);
        return nums[index-1];
        */
    }
}
// @lc code=end


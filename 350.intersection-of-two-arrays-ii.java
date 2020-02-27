import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        // 哈希映射
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0, len = nums1.length;
        for (int num : nums2) {
            if (cnt >= len) {
                break;
            }
            int t = map.getOrDefault(num, 0);
            if (t > 0) {
                nums1[cnt++] = num;
                map.put(num, t-1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, cnt);
    }
}
// @lc code=end


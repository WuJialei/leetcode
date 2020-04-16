import java.util.Arrays;

/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 */

// @lc code=start
class Solution {

    int[] h1;
    int[] h2;

    public boolean Judge (int cnt) {
        int i = 0; 
        int j = 0;
        for (; i < h1.length && j < h2.length;) {
            if ((h1[i] >= h2[j] - cnt) && (h1[i] <= h2[j] + cnt)) {
                ++i;
            } else {
                ++j;
            }
        }
        return i >= h1.length ? true : false;
    }

    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length < 1 || heaters.length < 1) {
            return 0;
        }
        Arrays.sort(houses);
        Arrays.sort(heaters);
        h1 = houses;
        h2 = heaters;
        // 注意左右边界
        int left = 0;
        // int right = houses[houses.length - 1] - houses[0];
        int right = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (left < right) {
            int mid = left + (right - left)/2;
            if (!Judge(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end


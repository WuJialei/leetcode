/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arrays = new int[26];
        for (char c : tasks) {
            arrays[c - 'A']++;
        }
        Arrays.sort(arrays);
        int cnt = (arrays[25] - 1) * (n + 1) + 1;
        int index = 24;
        while (index >= 0) {
            if (arrays[index] == arrays[25]) {
                ++cnt;
                --index;
            } else {
                break;
            }
        }
        // 如果task.length大于cnt，说明cnt留下的空位被填满，然后多出多少个空位就
        // 填多少个，即为数组长度
        return Math.max(cnt, tasks.length);
    }
}
// @lc code=end


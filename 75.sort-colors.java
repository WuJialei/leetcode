import java.util.Arrays;

/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // 三色旗问题，p0表示最右的0指针，p2表示最左的2指针，cur表示当前指针
        // 遇到0一定要处理，遇到2一定要处理，遇到1先跳过
        int p0 = 0, cur = 0, p2 = nums.length - 1;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                int tmp = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = tmp;
            } else if (nums[cur] == 2) {
                int tmp = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = tmp;
            } else {
                ++cur;
            }
        }
        /*
        int[] ret = sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = ret[i];
        }
        */
        //nums = Arrays.copyOfRange(sort(nums), 0, nums.length);
    }

    public int[] sort (int[] data) {
        if (data.length <= 1) {
            return data;
        }
        int mid = data.length >> 1;
        return merge(sort(Arrays.copyOfRange(data, 0, mid)), sort(Arrays.copyOfRange(data, mid, data.length)));
    }

    public int[] merge (int[] data1, int[] data2) {
        int[] ret = new int[data1.length + data2.length];
        int i = 0, j = 0;
        int cnt = 0;
        while (i < data1.length && j < data2.length) {
            if (data1[i] < data2[j]) {
                ret[cnt++] = data1[i++];
            } else {
                ret[cnt++] = data2[j++];
            }
        }
        while (i < data1.length) {
            ret[cnt++] = data1[i++];
        }
        while (j < data2.length) {
            ret[cnt++] = data2[j++];
        }
        return ret;
    }

}
// @lc code=end


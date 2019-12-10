/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        pair[] pairs = new pair[len];
        // nums[i]左侧比它小的里选最小的
        for (int i = 0; i < len; ++i) {
            pairs[i] = new pair();
            int val = nums[i];
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] < nums[i]) {
                    val = Math.min(val, pairs[j].pre);
                    break;
                } else {
                    --j;
                }
            }
            pairs[i].setPre(val);
        }
        // nums[i]右侧比它小的里选最大的
        for (int i = len - 1; i >= 0; --i) {
            int val = Integer.MIN_VALUE;
            int j = i + 1;
            while (j < len) {
                if (nums[j] < nums[i]) {
                    val = Math.max(val, nums[j]);
                }
                ++j;
            }
            pairs[i].setNext(val);
        }
        for (int i = 0; i < len; ++i) {
            if(pairs[i].pre < pairs[i].next && pairs[i].pre < nums[i] && pairs[i].next < nums[i]){
                return true;
            }
        }
        return false;
    }

    class pair {
        
        int pre;
        int next;
        
        public pair () {
            
        }
        
        public void setPre (int a) {
            pre = a;
        }
        
        public void setNext (int b) {
            next = b;
        }
    }
}
// @lc code=end


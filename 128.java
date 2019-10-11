import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        // int ans = Integer.MIN_VALUE;
        int ans = 1;
        int temp = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i-1]){
                continue;
            } else if (nums[i] - nums[i-1] == 1) {
                ++temp;
            } else {
                ans = Math.max(ans, temp);
                temp = 1;
            }
        }
        ans = Math.max(ans, temp);
        return ans;
        */
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : set) {
            if (!set.contains(num-1)) {
                int curAns = 1;
                while (set.contains(num + 1)) {
                    ++curAns;
                    num += 1;
                }
                ans = Math.max(ans, curAns);
            }
        }
        return ans;
    }
}
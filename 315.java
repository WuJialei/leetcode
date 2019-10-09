import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import javafx.print.Collation;

class Solution {

    public int lowbit (int val) {
        return val & (-val);
    }

    class BIT {

        private int[] nums;

        public BIT (int n) {
            nums = new int[n];
        }

        public void update(int i, int value) {
            while (i < nums.length) {
                nums[i] += value;
                i += lowbit(i);
            }
        }

        public int get (int i) {
            int sum = 0;
            while (i > 0) {
                sum += nums[i];
                i -= lowbit(i);
            }
            return sum;
        }
    };

    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for (int i = 0; i < sorted.length; ++i) {
            if (i == 0 || sorted[i] != sorted[i-1]) {
                map.put(sorted[i], ++index);
            }
        }
        BIT tree = new BIT(map.size());
        for (int i = nums.length - 1; i >= 0; --i) {
            ans.add(tree.get(map.get(nums[i]) - 1));
            tree.update(map.get(nums[i]), 1);
        }
        Collections.reverse(ans);
        return ans;
    }

}

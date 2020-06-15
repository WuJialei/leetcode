import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=728 lang=java
 *
 * [728] Self Dividing Numbers
 */

// @lc code=start
class Solution {

    public HashSet<Integer> num2set(int val) {
        HashSet<Integer> set = new HashSet<>();
        while (val > 0) {
            set.add(val%10);
            val /= 10;
        }
        return set;
    }

    public boolean divide(int val) {
        HashSet<Integer> set = num2set(val);
        if (set == null) {
            return false;
        }
        for (int l : set) {
            if (l == 0 || val % l != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (divide(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
// @lc code=end


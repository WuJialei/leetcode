import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1237 lang=java
 *
 * [1237] Find Positive Integer Solution for a Given Equation
 */

// @lc code=start
/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

/*
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int x = 1;
        int y = 1000;
        while (x <= 1000 && y >= 1) {
            int cur = customfunction.f(x, y);
            if (cur == z) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                ans.add(list);
                ++x;
                --y;
            } else if (cur < z) {
                ++x;
            } else {
                --y;
            }
        }
        return ans;
    }
}
*/
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= 1000; ++i) {
            if (customfunction.f(i, 1) > z) {
                break;
            }
            int left = 1;
            int right = 1000;
            while (left < right) {
                int mid = left + (right - left)/2;
                if (customfunction.f(i, mid) <= z) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            for (int j = 1; j < left; ++j) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
// @lc code=end


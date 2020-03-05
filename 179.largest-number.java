/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(
            list,
            (a, b) -> {
                String t1 = a + b;
                String t2 = b + a;
                return t2.compareTo(t1);
            }
        );
        StringBuilder ans = new StringBuilder("");
        for (String str : list) {
            ans.append(str);
        }
        if (ans.toString().charAt(0) == '0') {
            return "0";
        }
        return ans.toString();
    }
}
// @lc code=end


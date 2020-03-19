import java.util.List;

/*
 * @lc app=leetcode id=638 lang=java
 *
 * [638] Shopping Offers
 */

// @lc code=start
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += price.get(i) * needs.get(i);
        }
        for (List<Integer> offer : special) {
            boolean flag = true;
            for (int i = 0; i < n; ++i) {
                if (needs.get(i) - offer.get(i) < 0) {
                    flag = false;
                }
                needs.set(i, needs.get(i) - offer.get(i));
            }
            if (flag) {
                ans = Math.min(ans, offer.get(n) + shoppingOffers(price, special, needs));
            }
            for (int i = 0; i < n; ++i) {
                needs.set(i, needs.get(i) + offer.get(i));
            }
        }
        return ans;
    }
}
// @lc code=end


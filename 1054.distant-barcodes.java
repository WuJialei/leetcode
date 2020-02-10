import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int[] ans = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        int odd = 1, even = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            while (cnt > 0 && even < len) {
                ans[even] = num;
                even += 2;
                --cnt;
            }
            while (cnt > 0) {
                ans[odd] = num;
                odd += 2;
                --cnt;
            }
        }
        return ans;
    }
}
// @lc code=end


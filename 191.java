public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        int cnt = 32;
        while (cnt > 0) {
            if ((n&1) == 1) {
                ++ans;
            }
            n >>= 1;
            --cnt;
        }
        return ans;
    }
}

/*
 * @lc app=leetcode id=762 lang=java
 *
 * [762] Prime Number of Set Bits in Binary Representation
 */

// @lc code=start
class Solution {

    private boolean[] primes;

    public int oneCnt(int val) {
        int ret = 0;
        while (val > 0) {
            if ((val & 1) == 1) {
                ++ret;
            }
            val >>= 1;
        }
        return ret;
    }

    public void judgePrime() {
        primes[0] = true;
        primes[1] = false;
        primes[2] = true;
        for (int i = 3; i < 33; ++i) {
            primes[i] = true;
            for (int j = 2; j <= (i/2 + 1); ++j) {
                if (i % j == 0) {
                    primes[i] = false;
                    break;
                }
            }
        }
    }

    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        primes = new boolean[33];
        judgePrime();
        for (int num = L; num <= R; ++num) {
            int cnt = oneCnt(num);
            if (primes[cnt]) {
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end


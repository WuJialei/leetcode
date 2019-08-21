class Solution {
    public int hammingDistance(int x, int y) {
        // return Integer.bitCount(x ^ y);
        int z = x ^ y;
        int cnt = 0;
        while(z != 0) {
            if((z & 1) == 1) {
                ++cnt;
            }
            z = z >>> 1;
        }
        return cnt;
    }
}
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; ++i) {
        	int temp = n & 1;
        	n = n >>> 1;
        	ret = (ret << 1) | temp;
        }
        return ret;
    }
}
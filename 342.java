class Solution {
    public boolean isPowerOfFour(int num) {
        int cnt = 1;
        while(cnt > 0) {
        	if (cnt == num) {
        		return true;
        	}
        	cnt = cnt << 2;
        }
        return false;
    }
}
class Solution {
    public int trailingZeroes(int n) {
        if(n < 1){
        	return 0;
        }
        int result = 0;
        while(n != 0){
        	result += n/5;
        	n = n/5;
        }
        return result;
    }
}
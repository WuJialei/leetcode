class Solution {
    public int getSum(int a, int b) {
		int result = a ^ b;
		int next = a & b;
		if(next != 0) {
			return getSum(result, next << 1);
		}   
		return result;     
    }
}
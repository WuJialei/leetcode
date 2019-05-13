class Solution {
    public boolean judgeSquareSum(int c) {
		int start = 0;
		int end = (int) Math.sqrt(c) + 1;
		while(start <= end){
			int sum = start * start + end * end;
			if(sum == c){
				return true;
			}
			else if(sum > c){
				--end;
			}
			else{
				++start;
			}
		} 
		return false;
    }
}
class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int[] array = new int[128];
        int len = s.length();
        for(char temp : s.toCharArray()){
        	++array[temp];
        }
        int result = 0;
        for(int cnt : array){
        	result += (cnt / 2)*2;
        }
        if(result < len){
        	++result;
        }
        return result;
    }
}
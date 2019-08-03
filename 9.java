class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
        	return false;
        }
        String val = String.valueOf(x);
        int len = val.length();
        int left = 0, right = len - 1;
        while(left < right){
        	if(val.charAt(left) != val.charAt(right)){
        		return false;
        	}
        	++left;
        	--right;
        }
        return true;
    }
}
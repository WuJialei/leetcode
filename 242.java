class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for(char temp : s.toCharArray()){
        	++hash[temp - 'a'];
        }
        for(char temp : t.toCharArray()){
        	--hash[temp - 'a'];
        }
        for(int cnt : hash){
        	if(cnt != 0){
        		return false;
        	}
        }
        return true;
    }
}
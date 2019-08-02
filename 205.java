class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        for (int i = 0; i < s.length() ; ++i) {
        	if (sArray[s.charAt(i)] != tArray[t.charAt(i)]) {
        		return false;
        	}
        	sArray[s.charAt(i)] = i + 1;
        	tArray[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
class Solution {
    public int maxProduct(String[] words) {
    	if (words == null || words.length == 0) {
    		return 0;
    	}
        int n = words.length;
        int[] arrays = new int[n];
        int cnt = 0;
        for (String word : words) {
        	for (char c : word.toCharArray()) {
        		arrays[cnt] |= 1 << (c - 'a');
        	}
        	++cnt;
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
        	for (int j = i+1; j < n; ++j) {
        		if ((arrays[i] & arrays[j]) == 0) {
        			result = Math.max(result, words[i].length() * words[j].length());
        		}
        	}
        }
        return result;
    }
}
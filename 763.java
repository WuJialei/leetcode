class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<Integer>();
        int[] lastIndex = new int[26];
        for(int i = 0; i < S.length(); ++i){
        	lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int maxJump = 0;
        for(int j = 0; j < S.length(); ++j){
        	maxJump = Math.max(maxJump, lastIndex[S.charAt(j) - 'a']);
        	if(j == maxJump){
        		res.add(j - start + 1);
        		start = j + 1;
        	}
        }
        return res;
    }
}
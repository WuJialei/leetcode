class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for(String temp : d){
        	int j = 0;
        	for(int i = 0; i < s.length() && j < temp.length();){
        		if(s.charAt(i) == temp.charAt(j)){
        			++j;
        		}
        		++i;
        		if(j == temp.length()){
        			if(res.length() < temp.length() || (res.length() == temp.length() && res.compareTo(temp) > 0)){
        				res = temp;
        			}
        		}
        	}
        }
        return res;
    }
}
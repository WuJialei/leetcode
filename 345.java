class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels =  new HashSet<Character>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        if(s == null || s.length() == 0){
        	return s;
        }
        else{
        	int start = 0;
        	int end = s.length() - 1;
        	char[] temp = new char[s.length()];
        	while(start <= end){
        		char start_ch = s.charAt(start);
        		char end_ch = s.charAt(end);
        		if(!vowels.contains(start_ch)){
        			temp[start] = start_ch;
        			++start;
        		}
        		else if(!vowels.contains(end_ch)){
        			temp[end] = end_ch;
        			--end;
        		}
        		else{
        			temp[start] = end_ch;
        			temp[end] = start_ch;
        			++start;
        			--end;
        		}
        	}
        	return new String(temp);
        }
    }
}
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int flag = 0;
        String result = "";
        for(int i = len1-1, j = len2-1; i >= 0 || j >= 0 || flag == 1; --i, --j){
        	int x = i < 0 ? 0 : num1.charAt(i) - '0';
        	int y = j < 0 ? 0 : num2.charAt(j) - '0';
        	String sum = String.valueOf((x + y + flag) % 10);
        	flag = (x + y + flag) / 10;
        	result = sum + result;
        }
        return result;
    }
}
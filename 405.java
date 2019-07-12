class Solution {
    public String toHex(int num) {
        if(num == 0){
        	return "0";
        }
        String[] map = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "a", "b", "c", "d", "e", "f"};
        String result = "";
        while(num != 0){
        	result = map[num & 0b1111] + result;
        	num = num >>> 4;
        }
        return result;
    }
} 

// 405. Convert a Number to Hexadecimal
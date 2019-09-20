class Solution {
    public int titleToNumber(String s) {
        int ret = 0;
        for (char tmp : s.toCharArray()) {
            ret = ret * 26 + tmp - 'A' + 1;
        }
        return ret;
    }
}
class Solution {
    public int findComplement(int num) {
        int flag = 1 << 30;
        while((flag & num) == 0) {
        	flag = flag >> 1;
        }
        flag = (flag<<1) - 1;
        return flag ^ num;
    }
}
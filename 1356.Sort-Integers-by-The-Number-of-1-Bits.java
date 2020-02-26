class Solution {

    int num = 0xffffffff;

    public int bit (int val) {
        int cnt = 0;
        int t = 32;
        while (t > 0) {
            if ((val & 1) == 1) {
                ++cnt;
            }
            val = val >> 1;
            --t;
            
        }
        return cnt;
    }

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int v : arr) {
            list.add(v);
        }
        Collections.sort(list, 
            (a, b) -> {
                int aCnt = bit(a);
                int bCnt = bit(b);
                if ( aCnt == bCnt) {
                    return a - b;
                } else {
                    return aCnt - bCnt;
                }
            }
        );
        int[] ans = new int[list.size()];
        int i = 0;
        for (int t : list) {
            ans[i++] = t;
        }
        return ans;
    }
}
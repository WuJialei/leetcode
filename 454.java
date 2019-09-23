class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int cnt = 0;
        for (int a : A) {
            for (int b : B) {
                int temp = a + b;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int temp = - (c + d);
                if (map.containsKey(temp)) {
                    cnt += map.get(temp);
                }
            }
        }
        return cnt;
    }
}
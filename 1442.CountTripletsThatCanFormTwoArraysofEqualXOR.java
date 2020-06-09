class Solution {
    public int countTriplets(int[] arr) {
        // a = b <=> a ^ b = 0
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; ++i) {
            int tmp = arr[i];
            for (int k = i + 1; k < arr.length; ++k) {
                tmp ^= arr[k];
                if (tmp == 0) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
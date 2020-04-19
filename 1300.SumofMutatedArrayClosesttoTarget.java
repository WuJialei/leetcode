class Solution {

    private int[] arr;

    public int countSum(int th) {
        int ans = 0;
        for (int num : arr) {
            if (num > th) {
                ans += th;
            } else {
                ans += num;
            }
        }
        return ans;
    }

    public int findBestValue(int[] arr, int target) {
        this.arr = arr;
        int left = 1;
        int right = 100000;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (countSum(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int v1 = Math.abs(countSum(left - 1) - target);
        int v2 = Math.abs(countSum(left) - target);
        
        return v1 <= v2 ? left - 1 : left;

    }
}
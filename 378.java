class Solution {

	public int find (int[][] arrays, int target) {
		int n = arrays.length;
		int i = n - 1, j = 0;
		int num = 0;
		while (j < n && i >= 0) {
			if (arrays[i][j] > target) {
				--i;
			} else {
				num += i + 1;
				++j;
			}
		}
		return num;
	}

    public int kthSmallest(int[][] matrix, int k) {

		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int n = matrix.length;
		int low = matrix[0][0], high = matrix[n-1][n-1];
		while (low < high) {
			int mid = low + (high - low) / 2;
			int cnt = find(matrix, mid);
			if (cnt < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
        /* if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return 0;
        }
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left <= right){
        	int cnt = 0;
        	int mid = left + (right - left)/2;
        	for(int i = 0; i < n; ++i){
        		for(int j = 0; j < n; ++j){
        			if(matrix[i][j] <= mid){
        				++cnt;
        			}
        		}
        	}
        	if(cnt < k){
        		left = mid + 1;
        	}
        	else{
        		right = mid - 1;
        	}
        }
        return left; */
    }
}

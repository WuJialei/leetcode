class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) {
            return 0;
        }
        int len = s.length();
        if (k < 2) {
            return len;
        }
        return dfs(s.toCharArray(), 0, len - 1, k);
    }

    public int dfs (char[] arrays, int start, int end, int k) {
        if (end - start + 1 < k) {
            return 0;
        }
        int[] temp = new int[26];
        for (int i = start; i <= end; ++i) {
            ++temp[arrays[i]-'a'];
        }
        while (end - start + 1 >= k && temp[arrays[start]-'a'] < k) {
            ++start;
        }
        while (end - start + 1 >= k && temp[arrays[end]-'a'] < k) {
            --end;
        }
        if (end - start + 1 < k) { 
            return 0;
        } else {
            for (int j = start; j <= end; ++j) {
                if (temp[arrays[j]-'a'] < k) {
                    return Math.max(dfs(arrays, start, j - 1, k), dfs(arrays, j + 1, end, k));
                }
            }
            return end - start + 1;
        }
    }


}
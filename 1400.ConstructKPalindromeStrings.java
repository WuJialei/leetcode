class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int cnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                ++cnt;
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        if (cnt <= k) {
            return true;
        }
        int odd = 0;
        int even = 0;
        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 0) {
                ++even;
            } else {
                ++odd;
            }
        }
        return odd <= k ? true : false;
    }
}
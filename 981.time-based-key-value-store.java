import java.util.HashMap;

/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {


    HashMap<String, String>[] maps;
    HashMap<String, Integer> records;
    int val;

    /** Initialize your data structure here. */
    public TimeMap() {
        val = 1_0_000_000 + 5;
        maps = new HashMap[val];
        records = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if (maps[timestamp] == null) {
            maps[timestamp] = new HashMap<>();
        }
        maps[timestamp].put(key, value);
        records.put(key, timestamp);
    }
    
    public String get(String key, int timestamp) {
        if (records.containsKey(key)) {
            int index = records.get(key);
            if (index <= timestamp) {
                return maps[index].get(key);
            } else {
                int cnt = timestamp;
                while (cnt > 0) {
                    if (maps[cnt] != null && maps[cnt].containsKey(key)) {
                        return maps[cnt].get(key);
                    }
                    --cnt;
                }
                return "";
            }
            
        } else {
            return "";
        }
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end


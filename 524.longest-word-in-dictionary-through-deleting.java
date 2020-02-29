import java.util.Queue;

/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 */

// @lc code=start
class Solution {

    String s;

    public boolean find (String str) {
        int index = 0;
        int len = s.length();
        int cnt = 0;
        for (; cnt < str.length();) {
            if (index >= len) {
                break;
            }
            if (str.charAt(cnt) == s.charAt(index)) {
                ++cnt;
                ++index;
            } else {
                ++index;
            }
        }
        return cnt == str.length();
    }

    public String findLongestWord(String s, List<String> d) {
        this.s = s;
        List<String> list = new ArrayList<String>();
        for (String str : d) {
            if (find(str)) {
                if (list.size() == 0) {
                    list.add(str);
                } else {
                    if (str.length() == list.get(0).length()) {
                        list.add(str);
                    } else if (str.length() > list.get(0).length()) {
                        list = new ArrayList<String>();
                        list.add(str);
                    }
                }
                
            }
        }
        if (list.size() == 0) {
            return "";
        } else {
            if (list.size() > 1) {
                Collections.sort(list, (a, b) -> a.compareTo(b));
            }            
            return list.get(0);
        }
        
    }
}
// @lc code=end


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {

    public class Point {
        int first;
        int last;

        public void setFirst(int x) {
            first = x;
        }

        public void setLast(int y) {
            last = y;
        }
    }

    public List<Integer> partitionLabels(String S) {
        char[] indexs = new char[27];
        HashMap<Character, Point> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < S.length(); ++i) {
            char temp = S.charAt(i);
            if (!map.containsKey(temp)) {
                indexs[cnt++] = temp;
                map.put(temp, new Point());
                map.get(temp).setFirst(i);
                map.get(temp).setLast(i);
            } else {
                map.get(temp).setLast(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        int first1 = map.get(indexs[0]).first;
        int last1 = map.get(indexs[0]).last;
        for (int i = 1; i < cnt; ++i) {
            int first2 = map.get(indexs[i]).first;
            int last2 = map.get(indexs[i]).last;
            if (last1 < first2) {
                ans.add(last1 - first1 + 1);
                first1 = first2;
                last1 = last2;
            } else if (last2 > last1) {
                last1 = last2;
            }
        }
        ans.add(last1-first1+1);
        return ans;
    }
}
// @lc code=end


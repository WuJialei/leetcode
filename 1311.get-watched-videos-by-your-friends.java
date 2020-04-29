import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=1311 lang=java
 *
 * [1311] Get Watched Videos by Your Friends
 */

// @lc code=start
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(id);
        visited.add(id);
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        // for (String str : watchedVideos.get(id)) {
        //     map.put(str, map.getOrDefault(str, 0) + 1);
        // }
        while (!queue.isEmpty() && cnt < level) {
            Queue<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : friends[cur]) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        if (cnt == level - 1) {
                            for (String str : watchedVideos.get(next)) {
                                map.put(str, map.getOrDefault(str, 0) + 1);
                            }
                        }
                        
                        temp.offer(next);
                    }
                }
            }
            queue.addAll(temp);
            ++cnt;
        }
        if (queue.isEmpty()) {
            return new ArrayList<String>();
        } else {
            HashSet<String> ret = new HashSet<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (String str : watchedVideos.get(cur)) {
                    ret.add(str);
                }                
            }
            List<String> ans = new ArrayList<>();
            ans.addAll(ret);
            Collections.sort(ans, (a, b) -> {
                    if (map.get(a) == map.get(b)) {
                        return a.compareTo(b);
                    } else {
                        return map.get(a) - map.get(b);
                    }
                }
            );
            return ans;
        }
    }
}
// @lc code=end


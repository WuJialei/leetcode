import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {

    private int[] dir = {-1, 1};

    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int ans = -1;
        // bfs逐位旋转使得密码锁从”0000“到指定目标值，层次即需要的旋转次数
        // 判断是否访问过和是否是锁是接下来是否沿着它遍历的前提
        while (!queue.isEmpty()) {
            ++ans;
            Queue<String> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return ans;
                } 
                if (dead.contains(node)) {
                    continue;
                }
                for (int i = 0; i < 4; ++i) {
                    for (int d : dir) {
                        char c = (char)((node.charAt(i) - '0' + d + 10)%10 + '0');
                        String next = node.substring(0, i) + c + node.substring(i+1,4);
                        if (!visited.contains(next)) {
                            temp.offer(next);
                            visited.add(next);
                        }                        
                    }
                }
            }
            queue.addAll(temp);
        }
        return -1;
    }
}
// @lc code=end


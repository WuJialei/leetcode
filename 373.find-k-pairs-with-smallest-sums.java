import java.util.List;
import java.util.PriorityQueue;

import com.apple.concurrent.Dispatch.Priority;

/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {

    public class Data{
        int x, y;
        public Data(int a, int b){
            x = a;
            y = b;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                list.add(new Data(nums1[i], nums2[j]));
            }
        }
        Collections.sort(list, (a, b) -> (a.x + a.y) - (b.x + b.y));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k && i < list.size(); ++i) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(list.get(i).x);
            temp.add(list.get(i).y);
            ans.add(temp);
        }
        return ans;
        /*
        PriorityQueue<Data> queue = new PriorityQueue<>(k, (a, b) -> (b.x + b.y) - (a.x + a.y));
        for (int i = 0; i < nums1.length; ++i) {
            for(int j = 0; j < nums2.length; ++j) {
                Data data = new Data(nums1[i], nums2[j]);
                if (queue.size() < k) {
                    queue.offer(data);
                } else if (nums1[i] + nums2[j] < queue.peek().x + queue.peek().y) {
                    queue.poll();
                    queue.offer(data);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(data.x);
            temp.add(data.y);
            ans.add(temp);
        }
        return ans;
        */
    }
}
// @lc code=end


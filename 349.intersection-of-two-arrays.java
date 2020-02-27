import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<Integer>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                ++i;
                ++j;
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        int[] ans = new int[set.size()];
        int cnt = 0;
        for (int num : set) {
            ans[cnt++] = num;
        }
        return ans;
        /*
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : set1){
            if (set2.contains(num)) {
                list.add(num);
            }
        }
        int[] ans = new int[list.size()];
        int cnt = 0;
        for (int num : list) {
            ans[cnt++] = num;
        }
        return ans;
        */
    }
}
// @lc code=end


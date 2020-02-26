import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set  = new HashSet<>();
        for (int arr : arr2) {
            set.add(arr);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int arr : arr1) {
            map.put(arr, map.getOrDefault(arr, 0) + 1);
            if (!set.contains(arr)) {
                list.add(arr);
            }
        }
        Collections.sort(list);
        int i = 0, j = 0;
        for (; j < arr2.length; ++j) {
            int cnt = map.get(arr2[j]);
            while (cnt > 0) {
                arr1[i++] = arr2[j];
                --cnt;
            }
        }
        for (int l : list) {
            arr1[i++] = l;
        }
        return arr1;
    }
}
// @lc code=end


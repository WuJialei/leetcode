import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 */

// @lc code=start
class Solution {

    public int maxIndex (List<Integer> list) {
        int index = 0;
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) > list.get(index)) {
                index = i;
            }
        }
        return index;
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int a : A) {
            list.add(a);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = A.length - 1; i > 0; --i) {
            int j = maxIndex(list);
            if (j == i) {
                list.remove(j);
            } else {
                if (j > 0) {
                    List<Integer> list1 = list.subList(0, j+1);
                    List<Integer> list2 = list.subList(j+1, i+1);
                    ans.add(j+1);
                    Collections.reverse(list1);
                    list = new ArrayList<>();
                    list.addAll(list1);
                    list.addAll(list2);
                }
                Collections.reverse(list);
                ans.add(i+1);
                list.remove(i);
            }
        }
        return ans;
    }
}
// @lc code=end


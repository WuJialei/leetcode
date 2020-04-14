import java.util.Arrays;

/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        Arrays.sort(letters);
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left] > target ? letters[left]: letters[0];
    }
}
// @lc code=end


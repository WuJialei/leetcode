/*
 * @lc app=leetcode id=690 lang=java
 *
 * [690] Employee Importance
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int ans = 0;
        int index = -1;
        for (int i = 0; i < employees.size(); ++i) {
            if (employees.get(i).id == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return ans;
        }
        ans += employees.get(index).importance;
        for (int next : employees.get(index).subordinates) {
            ans += getImportance(employees, next);
        }
        return ans;
    }
}
// @lc code=end


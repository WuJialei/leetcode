import java.util.HashMap;

/*
 * @lc app=leetcode id=911 lang=java
 *
 * [911] Online Election
 */

// @lc code=start
class TopVotedCandidate {

    HashMap<Integer, Integer> count;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        count = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxVotePerson = -1;
        for (int i = 0; i < persons.length; ++i) {
            int time = times[i];
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if (maxVotePerson == -1) {
                maxVotePerson = persons[i];
            } else {
                maxVotePerson = map.get(persons[i]) >= map.get(maxVotePerson) ? persons[i] : maxVotePerson;
            }
            count.put(time, maxVotePerson);
        }
    }
    
    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        if (t >= times[right]) {
            return count.get(times[right]);
        }
        while (left < right) {
            int mid = left + (right - left)/2;
            if (times[mid] > t) {                     
                right = mid;
            } else {   
                left = mid + 1;
            }
        }
        return count.get(times[left-1]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
// @lc code=end


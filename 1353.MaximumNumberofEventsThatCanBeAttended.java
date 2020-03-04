import java.awt.List;
import java.util.HashSet;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(
            events,
            (a, b) -> a[1] - b[1]
        );
        HashSet<Integer> set = new HashSet<>();
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            for (int i = start; i <= end; ++i) {
                if (!set.contains(i)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }
}
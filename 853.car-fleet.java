import java.util.List;

/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {

    public class Car {
        int pos;
        int spe;
        double time;

        public Car (int p, int s, double t) {
            pos = p;
            spe = s;
            time = t;
        }

    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<Car>();
        for (int i = 0; i < position.length; ++i) {
            double t = (double)(target-position[i]) / (double)speed[i];
            Car car = new Car(position[i], speed[i], t);
            list.add(car);
        }
        Collections.sort(
            list,
            (a, b) -> {
                if (a.pos == b.pos) {
                    return a.spe - b.spe;
                } else {
                    return a.pos - b.pos;
                }
            }
        );
        int cnt = 0;
        for (int i = list.size() - 1; i >= 0; --i) {
            if (i <= list.size() - 2 && list.get(i).time <= list.get(i+1).time) {
                list.get(i).time = list.get(i+1).time;
            } else {
                ++cnt;
            }
        }
        return cnt;

    }
}
// @lc code=end


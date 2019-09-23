import java.util.HashMap;

class RandomizedSet {

    private HashMap<Integer, Integer> v2i;
    private HashMap<Integer, Integer> i2v;
    private int cnt;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        v2i = new HashMap<>();
        i2v = new HashMap<>();
        cnt = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (v2i.containsKey(val)) {
            return false;
        } else {
            v2i.put(val, cnt);
            i2v.put(cnt, val);
            ++cnt;
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (v2i.containsKey(val)) {
            if (v2i.size() == 1) {
                v2i.remove(val);
                i2v.remove(0);
            } else {
                int lastIndex = cnt - 1;
                int lastVal = i2v.get(lastIndex);
                int index = v2i.get(val);
                i2v.put(index, lastVal);
                i2v.remove(lastIndex);
                v2i.put(lastVal, index);
                v2i.put(val, cnt-1);
                v2i.remove(val);
            }
            --cnt;
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(cnt);
        return i2v.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
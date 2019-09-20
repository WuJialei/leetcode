import java.util.ArrayList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private int index;
    private List<Integer> nums;

    public List<Integer> init(List<NestedInteger> nestedList) {
        List<Integer> ret = new ArrayList<>();
        for (NestedInteger tmp : nestedList) {
            if (tmp.isInteger()) {
                ret.add(tmp.getInteger());
            } else {
                ret.addAll(init(tmp.getList()));
            }
        }
        return ret;
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        nums = new ArrayList<Integer>();
        index = -1;
        nums = init(nestedList);
    }

    @Override
    public Integer next() {
        if (index + 1 < nums.size()) {
            return nums.get(++index);
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if (index + 1 < nums.size()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
import java.util.*;

/**
 * Created by rrr on 2017/4/4.
 * 380. Insert Delete GetRandom O(1)
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
public class InsertDeleteGetRandomO1 {
    HashSet<Integer> sets ;
    Random random ;
    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        sets = new HashSet<>();
        random= new Random(47);
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (sets.contains(val)) return false;
        sets.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!sets.contains(val)) return false;
        sets.remove(val);
        return true;
    }


    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Iterator<Integer> iterator = sets.iterator();
        int rand=random.nextInt(sets.size());
        int res=iterator.next();
        while (rand>0&&iterator.hasNext()){res=iterator.next();rand--;}
        return res;
    }
}

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rrr on 2017/6/29.
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0) return result;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.pollLast();
            if (!deque.isEmpty()&&deque.peekFirst()<=i-size)deque.pollFirst();
            deque.offerLast(i);
            if (i >= size - 1) result.add(num[deque.peek()]);
        }
        return result;
    }
}

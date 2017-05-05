import java.util.*;

/**
 * Created by rrr on 2017/5/5.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {
    //未通过,牛客网JDK版本为1.7,PriorityQueue在1.8才加入
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0) return res;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        int i = 0;
        for (; i < k && i < input.length; i++) {
            queue.add(input[i]);
        }
        while (i < input.length) {
            if (queue.peek() > input[i]) {
                queue.poll();
                queue.add(input[i]);
            }
            i++;
        }
        res.addAll(queue);
        Collections.sort(res);
        return res;
    }

    //在input构建堆
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0|| k > input.length) return res;
        for (int i = input.length / 2 - 1; i >= 0; i--) {
            int child = i * 2 + 1;
            int root = i;
            while (child < input.length) {//最小堆
                if (child + 1 < input.length) child = input[child] < input[child + 1] ? child : child + 1;
                if (input[child] > input[root]) break;
                input[child] ^= input[root];
                input[root] ^= input[child];
                input[child] ^= input[root];
                root = child;
                child = root * 2 + 1;
            }
        }
//        System.out.println(Arrays.toString(input));
        int len = input.length - 1;
        while (k >=1) {
            int index = 0;
            res.add(input[0]);
            int tmp = input[len];
            input[len] = input[index];
            input[index] = tmp;
            len--;
            int child = index * 2 + 1;
            int root = index;
            while (child < len+1) {
                if (child + 1 < len+1) child = input[child] < input[child + 1] ? child : child + 1;
                if (input[child] > input[root]) break;
                input[child] ^= input[root];
                input[root] ^= input[child];
                input[child] ^= input[root];
                root = child;
                child = root * 2 + 1;
            }
            k--;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(GetLeastNumbers_Solution2(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4));

    }
}

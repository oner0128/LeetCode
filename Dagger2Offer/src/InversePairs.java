import java.util.Arrays;

/**
 * Created by rrr on 2017/5/7.
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    public int InversePairs(int[] array) {
        if (array==null||array.length==0)return 0;
        int[] copy = Arrays.copyOf(array,array.length);
        long count = helper(array, copy, 0, array.length - 1);
        return (int) (count % 1000000007);
    }

    private long helper(int[] array, int[] copy, int start, int end) {
        if (start >= end) {
            copy[start]=array[start];
            return 0;}
        else {
            int len = (end - start) >> 1;
            long left = helper(copy, array, start, start + len);
            long right = helper(copy, array, start + len + 1, end);
            long count = left + right;
            int p1 = start + len, p2 = end;
            int index = end;
            while (p1 >= start && p2 >= start + len + 1) {
                if (array[p1] > array[p2]) {
                    count += p2 - start - len;
                    copy[index--] = array[p1--];
                } else copy[index--] = array[p2--];
            }
            while (p1 >= start) copy[index--] = array[p1--];
            while (p2 >= start + len + 1) copy[index--] = array[p2--];
            return count;
        }
    }

    public static void main(String[] args) {

    }
}

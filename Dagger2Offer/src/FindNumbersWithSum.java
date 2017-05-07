import java.util.ArrayList;

/**
 * Created by rrr on 2017/5/4.
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        if (array.length <= 1 || array == null) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int lo = 0, hi = 1;
        while (hi < array.length && lo < hi) {
            if (array[lo] + array[hi] == sum) {
                res.add(array[lo]);
                res.add(array[hi]);
                break;
            } else if (array[lo] + array[hi] < sum) {
                if (hi == array.length - 1) lo++;
                else hi++;
            } else {
                lo++;
                hi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));
    }
}

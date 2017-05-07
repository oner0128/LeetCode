import java.util.ArrayList;

/**
 * Created by rrr on 2017/5/7.
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 0) return res;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = (int) Math.sqrt(2 * sum); i >=2; i--) {
            int a1 = sum / i - (i - 1) / 2;
            int j = 1, count = 0;
            while (j <= i) {
                count += a1;
                list.add(a1++);j++;
            }
            if (count == sum) res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(FindContinuousSequence(9));
    }
}

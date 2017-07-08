package medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rrr on 2017/7/8.
 * 60. Permutation Sequence
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    //超时Last executed input:
    //9
    //278082
    public static String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) return "";
        List<List<Integer>> res = new ArrayList<>();
        backtracing(n, 0, res, new ArrayList<>(), k);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : res.get(k - 1)) stringBuilder.append(num);
        return stringBuilder.toString();
    }

    private static void backtracing(int n, int start, List<List<Integer>> res, ArrayList<Integer> integers, int kth) {
        if (start == n) res.add(new ArrayList<>(integers));
        else for (int k = 1; k <= n; k++) {
            if (integers.contains(k)) continue;
            integers.add(k);
            backtracing(n, start + 1, res, integers, kth);
            if (res.size() >= kth) return;//此回溯法增加的结果是按大小排序的，只要res中的数目到达kth，该结果即为答案
            integers.remove(integers.size() - 1);
        }
    }
    //数学方法 根据排列组合的序号依次求出每位的数 14ms beat 94.1%
    public static String getPermutation2(int n, int k) {
        if (n <= 0 || k <= 0) return "";
        int factorial = 1;
        for (int i = 1; i <= n; i++)
            factorial *= i;
        boolean[] used = new boolean[n];
        StringBuilder nums = new StringBuilder();
        k -= 1;
        while (n > 0) {
            factorial = factorial / n;
            int seq = k / factorial;
            int i = 0;
            for (int mask=0; i < used.length; i++) {//seq的是未被使用的数的序号，需排除已使用的数
                if (used[i]==false)mask++;
                if (mask-1==seq)break;
            }
            nums.append(i + 1);
            used[i] = true;
            k = k % factorial;
            n--;
        }
        return nums.toString();
    }
    //LeetCode解法，跟方法2思路一样
    public String getPermutation3(int n, int k) {
        List<Integer> num = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--){
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 120; i++) {
            System.out.println(getPermutation2(5, i));
        }
    }
}

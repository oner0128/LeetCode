import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by rrr on 2017/3/5.
 * 66. Plus One
 */
public class PlusOne {
    //常规思路：从加法和进位入手，求余求进位
    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1, carry = 1;
        while (carry == 1 && i >= 0) {
            digits[i] = digits[i] + carry;
            carry = digits[i] / 10;
            digits[i] = digits[i--] % 10;
        }
        if (carry == 1) {
            int[] results = new int[digits.length + 1];
            for (int k = digits.length; k > 0; k--)
                results[k] = digits[k - 1];//两个数组大小不一样，并且从数组的最后一位开始复制
            results[0] = 1;System.out.println(Arrays.toString(results));
            return results;
        }System.out.println(Arrays.toString(digits));
        return digits;
    }

    //因为只在个位数加一，只有当数组的各位全是9时才需要创建新数组，
    // 只要有一位不是就可以返回原数组
    public static int[] plusOne2(int[] digits) {
        if (digits.length < 1) return new int[]{1};
        int i = digits.length - 1;
        while (i >= 0 && 9 == digits[i]) {
            digits[i--] = 0;
        }
        if (i == -1) {
            int[] results = new int[digits.length + 1];
            results[0] = 1;
            System.out.println(Arrays.toString(results));
            return results;
        } else {
            digits[i]++;
            System.out.println(Arrays.toString(digits));
            return digits;
        }
    }
    public int[] plusOne3(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }
    public static void main(String[] args) {
        int[] n = {9, 9, 9, 9};
        int[] n1 = {0, 9, 9, 9};
        int[] n2 = {8, 9, 2, 9};
        int[] n3 = {0};
        int[] n4 = {9};
        int[] n5 = {};
//        System.out.println(Arrays.toString(plusOne(n)));
        plusOne(n);
        plusOne(n1);
        plusOne(n2);
        plusOne(n3);
        plusOne(n4);
        plusOne(n5);
        int[] m = {9, 9, 9, 9};
        int[] m1 = {0, 8, 9, 9};
        int[] m2 = {8, 9, 2, 9};
        int[] m3 = {0};
        int[] m4 = {9};
        int[] m5 = {};
        plusOne2(m);
        plusOne2(m1); plusOne(m2);
        plusOne(m3);
        plusOne(m4);
        plusOne(m5);
    }
}

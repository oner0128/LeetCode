import java.util.Arrays;

/**
 * Created by hrong on 2017/1/8.
 * 338. Counting Bits
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 * and return them as an array.
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2]
 * 提示：位操作，动态规划：利用表来代替递归
 * ------------------------------------------------------
 * 自己的思路：以2^n为单位划分对应区间，求出该数的余，并该对应位的值+1即为当前值的bit是1的数目。
 * 例如：15以2为底的对数为3,15%(2^3)=7.即bit[15]=bit[7]+1
 * ------------------------------------------------------
 * 最优解
 * 思路：i与2i的在二进制中的操作是左移一位，它们的二进制1的个数相同
 * 例如；6为110；3为11；当遇到奇数时对最后一位求余即可；如bit[7]=111=bit[7>>1=3]+7&1=3
 * ------------------------------------------------
 * 总结：只利用了提示的动态规划，没有考虑位操作
 * 只要涉及到二进制，一般都会用到位操作
 */
public class CountBits {
    public static int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        int[] bits = new int[num + 1];
        bits[0] = 0;
        int log, mod;
        for (int i = 1; i <= num; i++) {
            log = (int) (Math.log(i) / Math.log(2));//logx(y) =loge(y) / loge(x)，换底公式
            mod = (int) (i % (Math.pow(2, (double) log)));
            bits[i] = bits[mod] + 1;
        }
        return bits;
    }
    public static int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(countBits(16)));
        System.out.println(Arrays.toString(countBits2(15)));
    }
}

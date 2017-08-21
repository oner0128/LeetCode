package medium;

/**
 * Created by rrr on 2017/8/21.
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * <p>
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    /* Submission Result: Wrong Answer More Details

     Input:
             -2147483648
             2
     Output:
             0
     Expected:
             -1073741824*/
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new ArithmeticException("/ by zero");
        if (dividend == 0) return 0;
        //handle overflow
        if (dividend >= Integer.MAX_VALUE && Math.abs(divisor) == 1)
            return divisor == 1 ? Integer.MAX_VALUE : -dividend;
        if (dividend <= Integer.MIN_VALUE && Math.abs(divisor) == 1)
            return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        long result = 0;
        boolean isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = Math.abs(dividend);//无法采用绝对值来求解，因为当dividend==Integer.MIN_VALUE时，绝对值失效
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        result = isPositive ? result : -result;
        result = result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
        result = result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result;
        return (int) result;
    }
    //LeetCode解法
    //自己思考时之能到减法，没想到结合位移，若只用减法，时间复杂度太高
    public int divide2(int dividend, int divisor) {
        //handle overflow
        if (divisor == 0) throw new ArithmeticException("/ by zero");
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;


        long result = 0;
        boolean isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long abdDividend = Math.abs((long)dividend);
        long absdivisor = Math.abs((long)divisor);
        while (abdDividend >= absdivisor) {
            long tmp=absdivisor,multi=1;
            while (abdDividend>=(tmp<<1)){
                multi<<=1;
                tmp<<=1;
            }
            abdDividend -= tmp;
            result+=multi;
        }
        return (int)(isPositive ? result : -result);
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide2(15, 3));
        System.out.println(new DivideTwoIntegers().divide2(Integer.MIN_VALUE, -2));
        System.out.println(Integer.MAX_VALUE + 1);
    }
}

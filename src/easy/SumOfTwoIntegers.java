package easy;

/**
 * Created by rrr on 2017/5/3.
 * 371. Sum of Two Integers
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 Example:
 Given a = 1 and b = 2, return 3.

 Tips:Bit Manipulation
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a==0||b==0)return a==0?b:a;
        while (b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }
    // Iterative
    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }
}

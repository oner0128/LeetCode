package easy;

/**
 * Created by rrr on 2017/8/22.
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

 Credits:
 Special thanks to @ts for adding this problem and creating all test cases.
 */
public class NumberOf1Bits {
    //hamming weight
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits=0;
        while (n!=0){
            bits++;
            n=n&(n-1);
        }
        return bits;
    }
}

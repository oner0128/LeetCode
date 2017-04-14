package HashTable;

/**
 * Created by rrr on 2017/4/10.
 * 137. Single Number II
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
    //完全不会
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;String bit1=Integer.toBinaryString(ones) ;
        String bit2=Integer.toBinaryString(twos) ;
        for(int i = 0; i < A.length; i++){
            bit1=Integer.toBinaryString(ones) ;
            bit2=Integer.toBinaryString(twos) ;
            ones = (ones ^ A[i]) & ~twos;
            bit1=Integer.toBinaryString(ones) ;
            bit2=Integer.toBinaryString(twos) ;
            twos = (twos ^ A[i]) & ~ones;
           bit1=Integer.toBinaryString(ones) ;
             bit2=Integer.toBinaryString(twos) ;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumber(new int[]{5,5,5,9,13,13,13}));
    }
}

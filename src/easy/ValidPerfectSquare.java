package easy;

/**
 * Created by rrr on 2017/6/17.
 * 367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Returns: True
 * Example 2:
 * <p>
 * Input: 14
 * Returns: False
 */
public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num <= 0) return false;
        long lo = 1, hi = num;//当lo,hi设置为int时，mid相乘会溢出
        while (lo <= hi) {
            long mid=lo+(hi-lo)/2;
            long sq=mid*mid;
            //需要把mid设置成long
            //int mid=lo+(hi-lo)/2;
            //long sq=mid*mid; 若这样写，在计算时mid*mid的结果还是int，会溢出，然后再变为long得到负数
            if (sq==num)return true;
            else if (sq<num)lo=mid+1;
            else hi=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(isPerfectSquare(808201));
    }
}

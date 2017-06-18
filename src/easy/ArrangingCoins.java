package easy;

/**
 * Created by rrr on 2017/6/18.
 * 441. Arranging Coins
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {
    //思路：等差数列和 ，ith层的总长度为n(a1+an)/2,a1=1,d=1,化简得到(i^2+i)/2=n,之后在1~n之间二分查找计算
    public static int arrangeCoins(int n) {
        if (n<=0)return 0;
        long lo=1,hi=n;
        long mid=lo+(hi-lo)/2;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            long s=(mid*mid+mid)/2;
            if (s==n)return (int) mid;
            else if (s>n)hi=mid-1;
            else if (s<n)lo=mid+1;
        }
        return (int)hi;
    }
    //思路：等差数列和 ，ith层的总长度为n(a1+an)/2,a1=1,d=1,化简得到(i^2+i)/2=n,
    //直接利用公式求出x1=(-b+sqrt(b^2-4ac))/2a.
    public static int arrangeCoins2(int n) {
        if (n<=0)return 0;
        return (int)(Math.sqrt(1+8*(double)n)-1)/2;
    }
    public static void main(String[] args) {
        System.out.println(arrangeCoins(457));
    }
}

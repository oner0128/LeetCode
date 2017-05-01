package easy;

/**
 * Created by rrr on 2017/5/1.
 * 69. Sqrt(x)
 * Implement int sqrt(int x).
 Compute and return the square root of x.

 Tips:Binary Search;Math
 */
public class SqrtX {
    //154ms beat 0.94% - -! 暴力算法
    public int mySqrt(int x) {
        if (x<=1)return x;
        int sqrt=0;
        for (int i = 2; i <= x; i++) {
            if (x/i==i){sqrt=i;break;}
            if (x/i+1==i){sqrt=i-1;break;}
        }
        return sqrt;
    }
    //LeetCode 2ms
    // Instead of using fancy Newton's method, this plain binary search approach also works.
    public static int mySqrt2(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    //2ms fancy Newton's method
    // x(k+1)=x(k)-f(x(k))/f'(x(k)),
    //x(k+1)=( x(k)+n/x(k) )/2
    public static int mySqrt3(int x) {
        if (x<=1)return x;
        double ans=x;
        double delta=0.00001;
        while (Math.abs(Math.pow(ans,2)-x)>delta)ans=(ans+x/ans)/2;
        return (int)ans;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt3(-1));
    }
}

package medium;

/**
 * Created by rrr on 2017/5/1.
 * 50. Pow(x, n)
 * Implement pow(x, n).
 */
public class Pow {
    /*Submission Result: Time Limit Exceeded More Details

    Last executed input:
            0.00001
            2147483647*/
    public double myPow(double x, int n) {
        if (n==0)return 1;
        double tmp=x;
        for (int i = 0; i < Math.abs(n); i++) {
            x*=tmp;
        }
        return n>=0?x:1/x;
    }
    //23ms
    public double myPow2(double x, int n) {
        if (n==0||x==1||x==0)return x==0?0:1;
        double ans=1;
        long m=n>0?n:-(long)n;
        while (m!=0){
            if (m%2==1)ans*=x;
            x*=x;
            m>>=1;
        }
        return n>=0?ans:1/ans;
    }
}

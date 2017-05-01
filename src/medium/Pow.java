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
    public double myPow2(double x, int n) {
        double delta=0.00001;
        double ans=x;
        int absN=Math.abs(n);
        while (absN-->0&&Math.abs(ans-x)>delta)ans*=x;
        return n>=0?ans:1/ans;
    }
}

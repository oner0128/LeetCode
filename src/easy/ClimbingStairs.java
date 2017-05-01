package easy;

/**
 * Created by rrr on 2017/4/28.
 * 70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
    //time O(n)  space O(n)
    public int climbStairs(int n) {
        int[]res=new int[n+1];
        res[0]=1;res[1]=1;
        for (int i = 2; i < n+1; i++) {
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }
    //time O(n)  space O(1)
    public int climbStairs2(int n) {
        int res=1;
        int one=1,two=1;
        for (int i = 2; i < n+1; i++) {
            res=one+two;
            one=two;
            two=res;
        }
        return res;
    }
}

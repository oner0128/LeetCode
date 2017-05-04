/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        int[][]q={{1,1},{1,0}};
        return helper(q,target);
    }
    private int helper(int[][] q, int n) {
        int[][]res={{1,0},{0,1}};
        while (n!=0){
            if (n%2==1)res=mult(res,q);
            q=mult(q,q);
            n>>=1;
        }
        return res[0][0];
    }

    private int[][] mult(int[][] res, int[][] q) {
        int[][]mul=new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mul[i][j]=res[i][0]*q[0][j]+res[i][1]*q[1][j];
            }
        }
        return mul;
    }

}

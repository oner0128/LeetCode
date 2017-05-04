/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        int[][]q={{1,1},{1,0}};
        return helper(q,n);
    }

    private int helper(int[][] q, int n) {
        int[][]res={{1,0},{0,1}};
        while (n!=0){
            if (n%2==1)res=mult(res,q);
            q=mult(q,q);
            n>>=1;
        }
        return res[0][1];
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

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(12));
    }
}

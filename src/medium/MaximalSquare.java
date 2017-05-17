package medium;

/**
 * Created by rrr on 2017/5/16.
 * 221. Maximal Square
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 answer:https://leetcode.com/articles/maximal-square/#approach-1-brute-force-accepted
 */
public class MaximalSquare {
    //17 ms
    public static int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return 0;
        int[][]dp=new int[matrix.length+1][matrix[0].length+1];
        int max=0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1]=='1'){
                    if (dp[i-1][j-1]==0||dp[i-1][j]==0||dp[i][j-1]==0)dp[i][j]=1;
                    else {
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                    max=Math.max(max,dp[i][j]);
                }else dp[i][j]=0;
            }
        }
        return max*max;
    }
    //LeetCode解法 dp
    //Time complexity : O(mn). Single pass.
    //Space complexity : O(mn). Another matrix of same size is used for dp.
    public static int maximalSquare2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
    //LeetCode解法  better dp  11 ms
   // Time complexity : O(mn)O(mn). Single pass.
    //Space complexity : O(n)O(n). Another array which stores elements in a row is used for dp.
    public static int maximalSquare3(char[][] matrix) {
        int rows=matrix.length;int cols=rows>0?matrix[0].length:0;
        int[]dp=new int[cols+1];
        int prev=0;int maxSquare=0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp=dp[j];
                if (matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(prev,dp[j-1]),dp[j])+1;
                    maxSquare=Math.max(maxSquare,dp[j]);
                }else dp[j]=0;
                prev=temp;
            }
        }
        return maxSquare*maxSquare;
    }
    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(maximalSquare(new char[][]{{'1','1','1','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(maximalSquare(new char[][]{}));

    }
}

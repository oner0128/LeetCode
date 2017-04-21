import java.util.Scanner;

/**
 * Created by rrr on 2017/4/20.
 * 题目描述
 题目标题：
 计算两个字符串的最大公共字串的长度，字符不区分大小写
 详细描述：
 接口说明
 原型：
 int getCommonStrLength(char * pFirstStr, char * pSecondStr);
 输入参数：
 char * pFirstStr //第一个字符串
 char * pSecondStr//第二个字符串

 */
public class LongestCommonSubString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            System.out.println(maxSubstringLength(input.next(),input.next()));
        }
    }
    //DP
    private static int maxSubstringLength(String str1, String str2) {
        int[][]dp=new int[str1.length()+1][str2.length()+1];
        int max=0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                char a=str1.charAt(i-1),b=str2.charAt(j-1);
                if (a==b)
                    dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=0;
                if (dp[i][j]>max)max=dp[i][j];
            }
        }
        return max;
    }
    private static int maxSubsequenceLength(String a, String b) {

        int aLen = a.length() + 1;
        int bLen = b.length() + 1;

        // 初始值默认为0
        int[][] f = new int[aLen][bLen];


        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[aLen - 1][bLen - 1];
    }
}

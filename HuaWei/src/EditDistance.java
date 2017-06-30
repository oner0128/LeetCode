import java.util.Scanner;

/**
 * Created by rrr on 2017/6/30.
 */
public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str1=scanner.next();
            String str2=scanner.next();
            System.out.println(getEditDistance(str1,str2));
        }
    }

    private static int getEditDistance(String str1, String str2) {
        int m=str1.length(),n=str2.length();
        int[][]dp=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1))
                dp[i][i]=dp[i-1][j-1];
                else dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
            }
        }
        return dp[m][n];
    }
}

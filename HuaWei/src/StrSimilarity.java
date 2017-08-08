import java.util.Scanner;

/**
 * Created by rrr on 2017/8/7.
 */
public class StrSimilarity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] str1 = scanner.nextLine().toLowerCase().toCharArray();
            char[] str2 = scanner.nextLine().toLowerCase().toCharArray();
            int[][] dp = new int[str1.length + 1][str2.length + 1];
            for (int i = 0; i <= str1.length; i++) dp[i][0] = i;
            for (int j = 0; j <= str2.length; j++) dp[0][j] = j;
            for (int i = 1; i <= str1.length; i++) {
                for (int j = 1; j <= str2.length; j++) {
                    if (str1[i-1] == str2[j-1]) dp[i][j] = Math.min(dp[i - 1][j]+1, Math.min(dp[i - 1][j - 1], dp[i][j - 1]+1));
                    else dp[i][j] = Math.min(dp[i - 1][j]+1, Math.min(dp[i - 1][j - 1]+1, dp[i][j - 1]+1));
                }
            }
            if (dp[str1.length][str2.length] == 0) System.out.println(1);
            else System.out.println("1/"+ (dp[str1.length][str2.length]+1));
        }
        scanner.close();
    }
}

package medium;

/**
 * Created by rrr on 2017/2/15.
 * 62. Unique Paths
 * Tips:Array,Dynamic Programming
 * 方法一采用DP方法求解
 * 4X4
 * 1 1 1 1
 * 1 2 3 4
 * 1 3 6 10
 * 1 4 10 20
 *map[i][j] = map[i-1][j]+map[i][j-1];
 * 空间复杂度可以压缩到O(min(m,n))
 *
 * 方法二不使用DP方法，用组合方式求解
 * 其实可以不使用动态规划求解。
 * 从“start“到”finish“的m*n,需要向下移动m-1步，向右移动n-1步
 * 即为排列组合中的组合，N=m+n-2;k=m-1;
 * Combination(N,k)=Combination(N, k) = n! / (k!(n - k)!)
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
    public static int uniquePaths2(int m, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[j] = arr[j] + arr[j-1];
            }
        }
        return arr[m-1];
    }

    //利用排列组合来解
    public static int uniquePaths3(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(6,4));System.out.println(uniquePaths2(4,6));
//        System.out.println(uniquePaths(4,2));
    }
}

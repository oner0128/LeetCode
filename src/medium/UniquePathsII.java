package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/2/15.
 * 63. Unique Paths II
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.
 */
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[width - 1];
    }
    public  static int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        //Empty case
        if(obstacleGrid.length == 0) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if(i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;// For row 0, if there are no paths to left cell, then its 0,else 1
                else if(j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;// For col 0, if there are no paths to upper cell, then its 0,else 1
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
            System.out.println(Arrays.toString(obstacleGrid[i]));
        }

        return obstacleGrid[rows - 1][cols - 1];

    }

    public static void main(String[] args) {
        int[][] obstacleGrid={{0,0,0,0},{0,0,0,0},{1,0,0,0},{0,0,0,0}};
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }
}

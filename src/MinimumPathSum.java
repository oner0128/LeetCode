import java.util.Arrays;

/**
 * Created by rrr on 2017/4/4.
 * 64. Minimum Path Sum
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 提示： Array Dynamic Programming
 */
public class MinimumPathSum {
    //与62. Unique Paths思路相同
    public static int minPathSum(int[][] grid) {
        System.out.println(Arrays.deepToString(grid));
        int rows = grid.length, cols = grid[0].length;
        int[][] results = new int[rows][cols];
        results[0][0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            results[0][i] = results[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            results[i][0] = results[i - 1][0] + grid[i][0];
        }
        System.out.println(Arrays.deepToString(results));
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int min=Math.min(results[i-1][j],results[i][j-1]);
                results[i][j]=min+grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(results));
        return results[rows-1][cols-1];
    }
    //无法自己优化到空间复杂度O(min(n，m))
    public static int minPathSum2(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] current = new int[cols];
        int[] pre = new int[cols];
        pre[0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            pre[i] = pre[i - 1] + grid[0][i];
        }
        System.out.println(Arrays.toString(pre));
        for (int i = 1; i < rows; i++) {
            current[0]=pre[0]+grid[i][0];
            for (int j = 1; j < cols; j++) {
                int min=Math.min(current[j-1],pre[j]);
                current[j]=min+grid[i][j];
            }System.out.println(Arrays.toString(current));
            System.arraycopy(current,0,pre,0,rows);
        }
        System.out.println(Arrays.toString(pre));
        return pre[cols-1];
    }
    private static void swap(int[] current, int[] pre) {
        int[]tmp=current;
        current=pre;
        pre=tmp;
    }
    public static int minPathSum3(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] current = new int[cols];
        current[0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            current[i] = current[i - 1] + grid[0][i];
        }
        System.out.println(Arrays.toString(current));
        for (int i = 1; i < rows; i++) {
            current[0]=current[0]+grid[i][0];
            for (int j = 1; j < cols; j++) {
                int min=Math.min(current[j-1],current[j]);
                current[j]=min+grid[i][j];
            }
        }
        System.out.println(Arrays.toString(current));
        return current[cols-1];
    }


    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
//        System.out.println(minPathSum(nums));
        int[][] nums2 = {{1,2,5},{3,2,1}};
        System.out.println(minPathSum(nums2));System.out.println(minPathSum3(nums2));
    }
}

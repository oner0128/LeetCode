import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/6.
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class Triangle {
    //类似62.Unique Paths和64. Minimum Path Sum的解法，利用动态规划
    //利用数组tri来保存每条路径的最小值
    //然后遍历tri找出最小的一条路径
    //up-down DP
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] tri = new int[triangle.size()];
        int row = 0;
        while (row < triangle.size()) {
            for (int j = row; j >= 0; j--) //从后往前遍历，使得tri[j]不会覆盖tri[j-1]，从而保存之前的状态
            {
                if (j == 0 ) tri[j] = triangle.get(row).get(j) + tri[j];
                else if ( j == row) tri[j] = triangle.get(row).get(j) + tri[j-1];
                else {
                    tri[j] = Math.min(tri[j - 1], tri[j]) + triangle.get(row).get(j);
                }
            }
            row++;
        }
        int minSum=tri[0];
        for (int k:tri)if (k<minSum)minSum=k;
        return minSum;
    }
    //bottom-up DP
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int[] tri = new int[triangle.size()];
        int n = triangle.size();
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            tri[i]=triangle.get(n - 1).get(i);
        }
        for (int layer = n-2; layer >= 0; layer--) // For each layer
        {
            for (int i = 0; i <= layer; i++) // Check its every 'node'
            {
                // Find the lesser of its two children, and sum the current value in the triangle with it.
                tri[i] = Math.min(tri[i], tri[i+1]) + triangle.get(layer).get(i);
            }
        }
        return tri[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(2));
        res.add(Arrays.asList(3,4));
        res.add(Arrays.asList(6,5,7));
        res.add(Arrays.asList(4,1,8,3));
        System.out.println(minimumTotal2(res));
        List<List<Integer>> res2 = new ArrayList<>();
        res2.add(Arrays.asList(-10));
        System.out.println(minimumTotal(res2));
//        List<List<Integer>> res3 = new ArrayList<>();
//        System.out.println(minimumTotal(res3));
    }
}

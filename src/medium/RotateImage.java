package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/4.
 * 48. Rotate Image
 * You are given an n x n 2D matrix representing an image.
 Rotate the image by 90 degrees (clockwise).
 Follow up:
 Could you do this in-place?
 */
public class RotateImage {
    //思路：顺时针旋转90度等价于先将矩阵转置后对每行以中心翻转,此方法还可以应用到逆时针中
    /*The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
        1  2  3
        4  5  6
        7  8  9
    after transpose, it will be swap(matrix[i][j], matrix[j][i])
        1  4  7
        2  5  8
        3  6  9
    Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
        7  4  1
        8  5  2
        9  6  3*/
    //与LeetCode解法一样
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        //转置
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        //对每行以中心翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][]nums={{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}

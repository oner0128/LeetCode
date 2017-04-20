package medium;

import java.util.Arrays;

/**
 * Created by rrr on 2017/4/4.
 * 59. Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
    int[][]matrix=new int[n][n];
        int rowBegin=0,colBegin=0;
        int rowEnd=n-1,colEnd=rowEnd;
        int count=1;
        while (rowBegin<=rowEnd&&colBegin<=colEnd){
            //Traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i]=count++;
            }
            rowBegin++;
            //Traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd]=count++;
            }
            colEnd--;
            //Traverse left
            if (colBegin<=colEnd)
                for (int i = colEnd; i >=colBegin; i--) {
                    matrix[rowEnd][i]=count++;
                }
            rowEnd--;
            //Traverse up
            if (rowBegin<=rowEnd)
            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin]=count++;
            }
            colBegin++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
}

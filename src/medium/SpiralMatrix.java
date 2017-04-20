package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrr on 2017/3/27.
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * For example,
 * Given the following matrix:
 * <p>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int rowLength = matrix.length;
        if (rowLength < 1) return results;
        int columLength = matrix[0].length;
        if (rowLength == 1) {
            for (int i = 0; i < columLength; i++) {
                results.add(matrix[0][i]);
            }
            return results;
        }
        int rows = rowLength;
        int colums = columLength;
        int i = 0, j = -1, n = 0, count = rowLength * columLength;
        int countRow = 0, countCol = 0;
        while (n < count) {
            n++;
            if (n == count - ((rowLength - 2) * (columLength - 2)) + 1) {
                colums--;
                rowLength -= 2;
                columLength -= 2;
                rows--;
                countRow++;
                countCol++;
            }
            if (i == countRow && j < colums - 1) {
                j++;
            } else if (i == rows - 1 && j > countCol) {
                j--;
            } else if ((j == colums - 1) && i < rows - 1) {
                i++;
            } else if (j == countCol && i > countRow) {
                i--;
            }
            results.add(matrix[i][j]);
        }
        return results;
    }
    //上面解法的代码优化
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int rowLength = matrix.length;
        if (rowLength < 1) return results;
        int columLength = matrix[0].length;
        int rows = rowLength;
        int colums = columLength;
        int i = 0, j = 0, count = rowLength * columLength;
        int countRow = 0, countCol = 0;
        while (0 < count) {
            results.add(matrix[i][j]);count--;
            if (count ==  ((rowLength - 2) * (columLength - 2))) {
                rowLength -= 2;
                columLength -= 2;
                colums--;
                rows--;
                countRow++;
                countCol++;
            }
            if (i == countRow && j < colums-1) {
                j++;
            } else if (i == rows - 1 && j > countCol) {
                j--;
            } else if ((j == colums - 1) && i < rows-1 ) {
                i++;
            } else if (j == countCol && i > countRow) {
                i--;
            }
        }
        return results;
    }
    //LeetCode解法
    //This is a very simple and easy to understand solution. I traverse right and increment rowBegin,
    // then traverse down and decrement colEnd, then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.
    //The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates.
    // If anyone can do the same thing without that check, please let me know!
    //Any comments greatly appreciated.
    public List<Integer> spiralOrder3(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {}
        };
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        int[][] matrix3 = {
                {1},
                {8},
                {7}
        };
        int[][] matrix4 = {
                {1, 2, 9}
        };
        int[][] matrix5 = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
        System.out.println(spiralOrder(matrix4));
        System.out.println(spiralOrder(matrix5));

        System.out.println(spiralOrder2(matrix));
        System.out.println(spiralOrder2(matrix2));
        System.out.println(spiralOrder2(matrix3));
        System.out.println(spiralOrder2(matrix4));System.out.println(spiralOrder2(matrix5));

    }
}

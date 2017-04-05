import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/5.
 * 73. Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        List<Integer>[] lists = new ArrayList[matrix.length];
        //counting
        for (int row = 0; row < matrix.length; row++) {
            lists[row] = new ArrayList<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[row][j] == 0) lists[row].add(j);
            }
        }
        //set zeros
        for (int row = 0; row < matrix.length; row++) {
            if (lists[row].size() != 0) {
                //set row zero
                for (int j = 0; j < matrix[0].length; j++)
                    matrix[row][j] = 0;
                //set col zero
                for (Integer col:lists[row]){
                    for (int i = 0; i < matrix.length; i++)
                        matrix[i][col] = 0;
                }
            }
        }
    }
//    My idea is simple: store states of each row in the first of that row, and store states of each column in the first of that column.
// Because the state of row0 and the state of column0 would occupy the same cell,
// I let it be the state of row0, and use another variable "col0" for column0.
// In the first phase, use matrix elements to set states in a top-down way.
// In the second phase, use states to set matrix elements in a bottom-up way.
    public static void setZeroes2(int[][] matrix) {
    int col0 = 1, rows = matrix.length, cols = matrix[0].length;

    for (int i = 0; i < rows; i++) {
        if (matrix[i][0] == 0) col0 = 0;
        for (int j = 1; j < cols; j++)
            if (matrix[i][j] == 0)
                matrix[i][0] = matrix[0][j] = 0;
    }

    for (int i = rows - 1; i >= 0; i--) {
        for (int j = cols - 1; j >= 1; j--)
            if (matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        if (col0 == 0) matrix[i][0] = 0;
    }}
    public static void main(String[] args) {
        int[][]matrix={{1,2,3},{1,2,3},{1,2,0}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        int[][]matrix2={{1,0}};
        setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
        int[][]matrix3={{1},{0}};
        setZeroes(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
        int[][]matrix5={{1,2,3},{1,0,3}};
        setZeroes(matrix5);
        System.out.println(Arrays.deepToString(matrix5));
    }
}

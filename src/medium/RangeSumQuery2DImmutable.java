package medium;

/**
 * Created by rrr on 2017/5/15.
 * 304. Range Sum Query 2D - Immutable
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * Example:
 * Given matrix = [
 * [3, 0, 1, 4, 2],
 * [5, 6, 3, 2, 1],
 * [1, 2, 0, 1, 5],
 * [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]
 * ]
 * <p>
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 */
public class RangeSumQuery2DImmutable {
    public class NumMatrix {
        int[][] sum;
        public NumMatrix(int[][] matrix) {
            if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
                sum = new int[matrix.length][matrix[0].length];
                sum[0][0] = matrix[0][0];
                //0 row
                for (int i = 1; i < matrix[0].length; i++) sum[0][i] = sum[0][i - 1] + matrix[0][i];
                //0 col
                for (int i = 1; i < matrix.length; i++) sum[i][0] = sum[i - 1][0] + matrix[i][0];
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 1; j < matrix[0].length; j++) {
                        sum[i][j] = sum[i - 1][j] +sum[i ][j-1] + matrix[i][j]-sum[i -1][j-1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sumRegion=sum[row2][col2];
            int sumRow1=row1==0?0:sum[row1-1][col2];
            int sumCol1=col1==0?0:sum[row2][col1-1];
            int fix=(col1==0||row1==0)?0:sum[row1-1][col1-1];
            return sumRegion-sumCol1-sumRow1+fix;
        }
    }

}

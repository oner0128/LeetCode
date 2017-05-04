import java.util.ArrayList;

/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix == null) return res;
        int nums = matrix.length * matrix[0].length;
        int i = 0;
        int j = 0;
        int rowEnd = matrix.length, colEnd = matrix[0].length;
        int rowStart = 0, colStart = 0;
        while (res.size() < nums) {
            //right
            while (j < colEnd&&res.size() < nums) res.add(matrix[i][j++]);
            colEnd--;
            j--;
            i++;
            //down
            while (i < rowEnd&&res.size() < nums) res.add(matrix[i++][j]);
            rowEnd--;
            i--;j--;
            //left
            while (j >= colStart&&res.size() < nums) res.add(matrix[i][j--]);
            colStart++;j++;i--;
            //up
            while (i > rowStart&&res.size() < nums) res.add(matrix[i--][j]);
            rowStart++;i++;j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(printMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
        System.out.println(printMatrix(new int[][]{{1}, {2}, {3},{2},{2},{2},{2},{1},{2}}));
        System.out.println(printMatrix(new int[][]{{}}));
    }
}

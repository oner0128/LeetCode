/**
 * Created by rrr on 2017/4/5.
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 For example,

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return true.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean find=false;
        int i=matrix.length-1,j=0;
        while (i>=0&&j<matrix[0].length){
            if (target==matrix[i][j]){find=true;break;}
            if (target>matrix[i][j])j++;
            else i--;
        }
        return find;
    }
}

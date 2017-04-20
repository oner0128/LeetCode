package medium;

/**
 * Created by rrr on 2017/4/5.
 * 240. Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 */
public class Search2DMatrixII {
    //O(m+n)
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean find = false;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j]) {
                find = true;
                break;
            }
            if (target < matrix[i][j]) i--;
            else j++;
        }
        return find;
    }

    //    O(mlogn) solution
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int first = 0, second = matrix.length - 1;
        int mid = 0;
        while (first < second) {
            mid = first + (second - first) / 2;
            if (target == matrix[0][mid]) {
                return true;
            }
            if (target < matrix[0][mid]) second = mid;
            else first = mid + 1;
        }
        int col = mid;
        first = 0;
        second = matrix[0].length - 1;
        while (first < second) {
            mid = first + (second - first) / 2;
            if (target == matrix[mid][col]) {
                return true;
            }
            if (target < matrix[mid][col]) second = mid;
            else first = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(nums, 5));
        System.out.println(searchMatrix(nums, 20));
        System.out.println(searchMatrix2(nums, 5));
        System.out.println(searchMatrix2(nums, 20));
        int[][] nums2 = {};System.out.println(searchMatrix(nums2, 0));
    }
}

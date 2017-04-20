package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rrr on 2017/4/4.
 * 118. Pascal's medium.Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * For example, given numRows = 5,
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    //超时
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][]cur=new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j==0||j==i)cur[i][j]=1;
                else cur[i][j]=cur[i-1][j]+cur[i-1][j-1];
            }
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> integers=new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                integers.add(cur[i][j]);
            }
            res.add(integers);
        }
        return res;
    }
    //减少为一个循环后可以通过
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][]cur=new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> integers=new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if (j==0||j==i)cur[i][j]=1;
                else cur[i][j]=cur[i-1][j]+cur[i-1][j-1];
                integers.add(cur[i][j]);
            }
            res.add(integers);
        }
        return res;
    }
    //LeetCode大神解法
    public static List<List<Integer>> generate3(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }

    public static void main(String[] args) {
        System.out.println(generate3(5));System.out.println(generate(2)); System.out.println(generate(0));
        System.out.println(generate2(5));System.out.println(generate2(2)); System.out.println(generate2(0));
    }
}

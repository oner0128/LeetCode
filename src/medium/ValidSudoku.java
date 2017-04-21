package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rrr on 2017/4/21.
 * 36. Valid Sudoku
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set set=new HashSet();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]=='.')continue;
                String s="("+board[i][j]+")";
                if (!set.add(i+s)||!set.add(s+j)||!set.add(i/3+s+j/3))return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku2(char[][] board) {
        boolean[][]row=new boolean[9][9];
        boolean[][]col=new boolean[9][9];
        boolean[][]bolck=new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]=='.')continue;
                int num=board[i][j]-'0'-1;int k=3*(i/3)+(j/3);
                if (row[i][num]||col[j][num]||bolck[k][num])return false;
                row[i][num]=col[j][num]=bolck[k][num]=true;
            }
        }
        return true;
    }

}

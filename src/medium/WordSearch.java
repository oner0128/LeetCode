package medium;

//79. Word Search
/*
* Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
public class WordSearch {
    private boolean isFind = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                backtracing(board, word, i, j, 0, new boolean[board.length][board[0].length]);
        return isFind;
    }

    private void backtracing(char[][] board, String word, int row, int col, int count, boolean[][] booleans) {
        if (count == word.length()) {
            isFind = true;
            return;
        }
        if (isFind == true || row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return;
        else if (board[row][col] == word.charAt(count) && booleans[row][col] == false) {
            booleans[row][col] = true;
            count++;
            backtracing(board, word, row - 1, col, count, booleans);
            backtracing(board, word, row + 1, col, count, booleans);
            backtracing(board, word, row, col - 1, count, booleans);
            backtracing(board, word, row, col + 1, count, booleans);
            booleans[row][col] = false;//booleans在每一个回溯中相当于全局变量
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(board, "SEE"));
        System.out.println(new WordSearch().exist(board, "ABCCED"));
        System.out.println(new WordSearch().exist(board, "ABCBQQ"));


        char[][] board2 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch().exist(board2, "ABCESEEEFS"));
    }
}

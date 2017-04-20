package medium;

import com.sun.javafx.logging.Logger;
import com.sun.javafx.util.Logging;
import com.sun.javafx.util.Utils;
import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hrong on 2017/1/8.
 * 419. Battleships in a Board
 * 给定一个2维板，计算其中包含多少艘不同的战舰。战舰用字符'X'表示，空白槽位用'.'表示。你应该假设如下规则：
 给定的板子是有效的，只包含战舰和空白槽位。
 战舰只能水平或者竖直放置。
 战舰的尺寸可能不同。
 两艘战舰之间在水平方向或者竖直方向至少包含一个空间—不会存在相邻的战舰。
 */
public class CountBattleships {
    public static int countBattleships(char[][] board) {
        int length = board[0].length;
        int nums = board.length;
        if (length == 0) return 0;
        int battleShips = 0;
        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j]!='X')continue;//continue结束本层的本次循环；break结束本层的循环
                if (i>0&&board[i-1][j]=='X')continue;//当用||时将大概率为真的条件语句放在前面（可以避免执行第二个条件语句）；当用&&时将大概率为假的条件语句放在前面
                if (j>0&&board[i][j-1]=='X')continue;
                battleShips++;
            }
        }
        return battleShips;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', '.', '.', 'X'}, {'.', 'X', '.', 'X'}, {'X', '.', '.', 'X'}};
        System.out.println("the number of battleShips : "+countBattleships(board));
    }
}

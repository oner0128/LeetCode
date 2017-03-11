/**
 * Created by rrr on 2017/3/10.
 */
public class Queen {
    //同栏是否有皇后，1表示有
    private int[] column;

    //右上至左下是否有皇后
    private int[] rup;

    //左上至右下是否有皇后
    private int[] lup;

    //解答
    private int[] queen;

    //解答编号
    private int num;

    public Queen() {
        column = new int[8 + 1];
        rup = new int[(2 * 8) + 1];
        lup = new int[(2 * 8) + 1];

        for (int i = 1; i <= 8; i++)
            column[i] = 0;

        for (int i = 1; i <= (2 * 8); i++)
            rup[i] = lup[i] = 0;  //初始定义全部无皇后

        queen = new int[8 + 1];
    }

    public void backtrack(int i) {
        if (i > 8) {
            showAnswer();
        } else {
            for (int j = 1; j <= 8; j++) {
                if ((column[j] == 0) && (rup[i + j] == 0) && (lup[i - j + 8] == 0)) {//若无皇后
                    queen[i] = j;
                    column[j] = rup[i + j] = lup[i - j + 8] = 1;//设定为占用
                    backtrack(i + 1);  //循环调用
                    column[j] = rup[i + j] = lup[i - j + 8] = 0;//若下一行无法找到可以放皇后的位置，说明当前i行j列不可行。设定为不占用
                }
            }
        }
    }

    protected void showAnswer() {
        num++;
        System.out.println("\n解答" + num);
        for (int y = 1; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                if (queen[y] == x) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }System.out.println("\""+y+","+queen[y] +"\"");
        }
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.backtrack(1);
    }
}
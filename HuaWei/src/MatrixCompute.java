import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rrr on 2017/4/20.
 * 题目描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * <p>
 * 例如：
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * <p>
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * <p>
 * 编写程序计算不同的计算顺序需要进行的乘法次数
 */
public class MatrixCompute {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            int[][] matrix = new int[n][2];
            for (int i = 0; i < n; i++) {
                matrix[i][0] = input.nextInt();
                matrix[i][1] = input.nextInt();
            }
            String cli = input.next();
            int i = 0;
            while (i < cli.length()) {
//                if ()
            }
        }
    }
}

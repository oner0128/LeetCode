import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rrr on 2017/6/27.
 * 题目描述
 矩阵乘法的运算量与矩阵乘法的顺序强相关。

 例如：
 A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵

 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。

 编写程序计算不同的计算顺序需要进行的乘法次数
 */
public class MatrixComputing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int matrixNums = scanner.nextInt();
            int[][] maxtrix = new int[matrixNums][2];
            for (int i = 0; i < matrixNums; i++) {
                maxtrix[i][0] = scanner.nextInt();
                maxtrix[i][1] = scanner.nextInt();
            }
            String rule = scanner.next();
            System.out.println(getResult(maxtrix, rule));
        }
    }

    private static int getResult(int[][] maxtrix, String rule) {
        int computingNums = 0;
        Stack<Integer> stack = new Stack<>();
        int k=0;
        for (int i = 0; i < rule.length(); i++) {
            if (rule.charAt(i) == '(') continue;
            else if (rule.charAt(i) == ')') {
                if (stack.size()<2)return computingNums;
                int b=stack.pop(),a=stack.pop();
                computingNums+=maxtrix[a][0]*maxtrix[a][1]*maxtrix[b][1];
                maxtrix[a][1]=maxtrix[b][1];
                stack.push(a);
            } else if (k<maxtrix.length)stack.push(k++);
        }
        return computingNums;
    }
}

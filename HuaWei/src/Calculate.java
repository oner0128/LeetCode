import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 * 请实现如下接口
    功能：四则运算
     * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
         * 返回：算术表达式的计算结果
约束：
pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
pucExpression算术表达式的有效性由调用者保证
 */
public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String exp = scanner.nextLine();
            System.out.println(calculate(exp));
        }
    }

    public static int calculate(String exp) {
        char[] chars = exp.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') count++;
        }
        return count;
    }
}

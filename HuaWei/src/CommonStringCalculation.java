import java.util.Scanner;

/**
 * Created by rrr on 2017/3/23.
 * 题目标题：
 * 计算两个字符串的最大公共字串的长度，字符不区分大小写
 * 详细描述：
 * 接口说明
 * 原型：
 * int getCommonStrLength(char * pFirstStr, char * pSecondStr);
 * 输入参数：
 * char * pFirstStr //第一个字符串
 * char * pSecondStr//第二个字符串
 */
public class CommonStringCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String firstString = scanner.next().toLowerCase();
            String secondString = scanner.next().toLowerCase();
            int firstStringLength = firstString.length(), secondStringLength = secondString.length();
            if (firstStringLength <= secondStringLength)
                System.out.println(commonStringCalculation(firstString, secondString));
            else System.out.println(commonStringCalculation(secondString, firstString));
        }
    }

    public static int commonStringCalculation(String firstString, String secondString) {
        int firstStringLength = firstString.length();
        for (int i = firstStringLength; i > 0; i--) {
            for (int j = 0; (j + i) <= firstStringLength; j++) {
                if (secondString.contains(firstString.substring(j, j + i))) return i;
            }
        }
        return 0;
    }
}

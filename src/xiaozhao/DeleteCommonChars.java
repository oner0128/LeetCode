package xiaozhao;

import java.util.Scanner;

/**
 * Created by rrr on 2017/8/21.
 * 题目描述
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 * 输入描述:
 * 每个测试输入包含2个字符串
 * 输出描述:
 * 输出删除后的字符串
 * 示例1
 * 输入
 * <p>
 * They are students.
 * aeiou
 * 输出
 * <p>
 * Thy r stdnts.
 */
public class DeleteCommonChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();

            StringBuilder stringBuilder = new StringBuilder(first);

            for (char c : second.toCharArray()) {
                while (stringBuilder.indexOf(c + "") >= 0)
                    stringBuilder.deleteCharAt(stringBuilder.indexOf(c + ""));
            }
            System.out.println(stringBuilder.toString());
        }
    }
}

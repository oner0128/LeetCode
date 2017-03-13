import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 * 找出给定字符串中大写字符(即'A'-'Z')的个数
 * 接口说明
 * 原型：int CalcCapital(String str);
 * 返回值：int
 */
public class UpperCaseNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(upperCaseNums(str));
        }
    }

    public static int upperCaseNums(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') count++;
        }
        return count;
    }
}

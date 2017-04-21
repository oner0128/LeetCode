import java.util.Scanner;

/**
 * Created by rrr on 2017/4/21.
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class Cut8String {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String strA = input.next();
            String strB = input.next();
            while (strA.length() > 0) {
                if (strA.length() == 8) {
                    System.out.println(strA);
                    strA = "";
                } else if (strA.length() > 8) {
                    System.out.println(strA.substring(0, 8));
                    strA = strA.substring(8, strA.length());
                } else {
                    StringBuilder stringBuilder=new StringBuilder(strA);
                    for (int i = 0; i < 8 - strA.length(); i++) {
                        stringBuilder.append(0);
                    }
                    System.out.println(stringBuilder.toString());
                    strA="";
                }
            }
            while (strB.length() > 0) {
                if (strB.length() == 8) {
                    System.out.println(strB);
                    strB = "";
                } else if (strB.length() > 8) {
                    System.out.println(strB.substring(0, 8));
                    strB = strB.substring(8, strB.length());
                } else {
                    StringBuilder stringBuilder=new StringBuilder(strB);
                    for (int i = 0; i < 8 - strB.length(); i++) {
                        stringBuilder.append(0);
                    }strB=""; System.out.println(stringBuilder.toString());
                }
            }
        }
    }
}

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/21.
 * 题目描述
 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 输入描述:
 输入一个有字母和数字以及空格组成的字符串，和一个字符。
 输出描述:
 输出输入字符串中含有该字符的个数。
 输入例子:
 ABCDEF
 A
 输出例子:
 1
 */
public class CountStrB {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String strA = input.next().toLowerCase();
            String strB=input.next().toLowerCase();
            int[]count=new int[128];
            char[]charA=strA.toCharArray();
            for (char c:charA)count[c]++;
            System.out.println(count[strB.charAt(0)]);
        }
    }
}

import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 * 题目描述
 描述：
 输入一个整数，将这个整数以字符串的形式逆序输出
 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 输入描述:
 输入一个int整数
 输出描述:
 将这个整数以字符串的形式逆序输出
 输入例子:
 1516000
 输出例子:
 0006151
 */
public class NumberDown {
    public static void main(String[] args) {
        Scanner scanner=new Scanner((System.in));
        int num=scanner.nextInt();
        System.out.println(numberDown(num));
    }

    private static String numberDown(int num) {
        StringBuilder stringBuilder=new StringBuilder();
        while (num>0){
            int carry=num%10;
            stringBuilder.append(carry);
            num=num/10;
        }
        return stringBuilder.toString();
    }
}

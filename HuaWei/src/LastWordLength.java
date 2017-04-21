import java.util.Scanner;

/**
 * Created by rrr on 2017/4/21.
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 输入描述:
 一行字符串，非空，长度小于5000。
 输出描述:
 整数N，最后一个单词的长度。
 输入例子:
 hello world
 输出例子:
 5
 */
public class LastWordLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String[] str = input.nextLine().split(" ");
            System.out.println(str[str.length-1].length());
        }
    }
}

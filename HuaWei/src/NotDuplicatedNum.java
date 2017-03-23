import java.util.Scanner;

/**
 * Created by rrr on 2017/3/23.
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * <p>
 * 输入描述:
 * 输入一个int型整数
 * <p>
 * <p>
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 输入例子:
 * 9876673
 * <p>
 * 输出例子:
 * 37689
 */
public class NotDuplicatedNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(notDuplicatedNum(scanner.nextInt()));
        }
    }

    public static int notDuplicatedNum(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] marked = new boolean[11];
        while (num > 0) {
            int mod = num % 10;
            if (marked[mod] == false){
                stringBuilder.append(mod);
                marked[mod] =true;}
            num /= 10;
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}

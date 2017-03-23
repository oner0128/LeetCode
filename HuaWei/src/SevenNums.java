import java.util.Scanner;

/**
 * Created by rrr on 2017/3/23.
 * 题目描述
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 */
public class SevenNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(sevenNums(scanner.nextInt()));
        }
    }

    public static int sevenNums(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 7 == 0) result++;
            else if (Integer.valueOf(i).toString().matches("\\d*7\\d*"))result++;
        }
        return result;
    }
}

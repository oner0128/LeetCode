import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 * 统计不同字符的个人，不是统计在0-127内的字符个数
 */
public class CharNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String exp = scanner.nextLine();
            System.out.println(charNums(exp));
        }
    }

    public static int charNums(String exp) {
        int[] trues = new int[128];
        int count = 0;
        char[] chars = exp.toCharArray();
        for (char c : chars) {
            trues[c] = 1;
        }
        for (int i = 0; i < trues.length; i++) {
            if (trues[i]==1)count++;
        }
        return count;
    }
}

package NieKe.WangYi;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class BoyAndGirl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arrays = str.toCharArray();
        char[] arrays2 = str.toCharArray();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == 'B') for (int j = i; j > 0 && arrays[j] != arrays[j- 1]; j--) {
                char tmp = arrays[j];
                arrays[j] = arrays[j - 1];
                arrays[j - 1] = tmp;
                count1++;
            }
        }
        for (int i = 0; i < arrays2.length; i++) {
            if (arrays2[i] == 'G') for (int j = i; j > 0 && arrays2[j] != arrays2[j - 1]; j--) {
                char tmp = arrays2[j];
                arrays2[j] = arrays2[j - 1];
                arrays2[j - 1] = tmp;
                count2++;
            }
        }
        System.out.println(count1 > count2 ? count2 : count1);
    }
}

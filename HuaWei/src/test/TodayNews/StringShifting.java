package test.TodayNews;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/17.
 */
public class StringShifting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[]chars=str.toCharArray();
            int len=str.length();  int count=0;
            int head;
            for (int i = 0; i < len; i++) {
                head=0;
                chars[head]^=chars[len-1];
                chars[len-1]^=chars[head];
                chars[head]^=chars[len-1];
                if (str.equals(String.copyValueOf(chars)))count++;
            }
            System.out.println(count);
        }
    }
}

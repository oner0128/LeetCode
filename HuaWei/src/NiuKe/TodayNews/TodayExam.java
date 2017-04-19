package NiuKe.TodayNews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/17.
 */
public class TodayExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] dn = new int[n];
            for (int i = 0; i < n; i++) {
                dn[i] = scanner.nextInt();
            }
            Arrays.sort(dn);
            int i=0;

        }
    }
}

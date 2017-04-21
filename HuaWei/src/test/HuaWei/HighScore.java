package test.HuaWei;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class HighScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str1 = scanner.nextLine().split(" ");
            int m = Integer.parseInt(str1[0]), n = Integer.parseInt(str1[1]);
            String[] str2 = scanner.nextLine().split(" ");
            int[] score = new int[m];
            for (int i = 0; i < m; i++) {
                score[i] = Integer.parseInt(str2[i]);
            }
            for (int i = 0; i < n; i++) {
                String[] str3 = scanner.nextLine().split(" ");
                int one = Integer.parseInt(str3[1]);
                int two = Integer.parseInt(str3[2]);
                if (str3[0].equals("Q")) {
                    int max = 0;
                    if (one > two) {
                        int tmp = one;
                        one = two;
                        two = tmp;
                    }
                    for (int j = one-1; j < two; j++) {
                        max = Math.max(max, score[j]);
                    }
                    System.out.println(max);
                } else score[one-1] = two;
            }
        }
    }
}

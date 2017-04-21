package test.HuaWei;

import java.util.*;

/**
 * Created by rrr on 2017/4/21.
 */
public class DeleteNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n > 1000) n = 999;
            boolean[] delete = new boolean[n];
            int num = 0;
            int count = 0;
            int i = 0;
            while (num != n) {
                if (delete[i % n] == false) {
                    if (count == 2) {
                        delete[i  % n] = true;
                        num++;
                        count = 0;
                    } else count++;
                }
                i++;
            }
        System.out.println((i-1)%n);
        }
    }
}

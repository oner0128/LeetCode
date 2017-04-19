package NiuKe.TodayNews;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/17.
 */
public class XOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] dn = new int[n];
            for (int i = 0; i < n; i++) {
                dn[i] = scanner.nextInt();
            }
            int count=0;
            Arrays.sort(dn);
            for (int i = 0; i < n; i++) {
                while (i<n-1&&dn[i]==dn[i+1])i++;
                for (int j = i+1; j < n; j++) {
                    while (j<n-1&&dn[j]==dn[j+1])j++;
                    if ((dn[i]^dn[j])>m)count++;
                }
            }
            System.out.println(count);
        }
    }
}

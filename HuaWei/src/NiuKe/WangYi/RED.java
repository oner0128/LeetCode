package NiuKe.WangYi;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class RED {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        char[][] grid = new char[num][num];
        for (int i = 0; i < num; i++)
            grid[i] = scanner.next().toCharArray();
        int[] colsMax = new int[num];
        int max = 1;
        for (int i = 0; i < num; i++) {
            int lo = 0, hi = 1;
            int colMax = 1;
            while (lo < num && hi < num) {
                if (grid[lo][i] == grid[hi][i]) {
                    colMax = Math.max(colMax, hi - lo+1);
                    max = Math.max(colMax, max);
                    hi++;
                } else lo = hi++;
            }
            colsMax[i] = colMax;
        }
        int cells=0;
        for (int i = 0; i < num; i++) {
            if (colsMax[i]==max)cells+=max;
        }
        System.out.println(cells);
    }
}

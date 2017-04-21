package test.HuaWei;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/21.
 */
public class Bottle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int bottleNums = scanner.nextInt();
            System.out.println(getNum(bottleNums));
        }
    }


    private static int getNum(int bottleNums) {
        int num = 0;
        while (bottleNums > 2) {
            num += bottleNums / 3;
            int mod = bottleNums % 3;
            bottleNums = bottleNums / 3 + mod;
        }
        if (bottleNums >= 2) num += 1;
        return num;
    }
}

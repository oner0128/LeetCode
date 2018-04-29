package xiaozhao;

import java.util.Scanner;

public class Transform {
    public static String transform(long number) {
        String result = "";
        String numbers = String.valueOf(number);
        String[] chineseNunmber = {"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] placeholders = {"", "十", "百", "千", "万", "亿"};
        int carryCount = 0;
        while (number > 0) {
            long cur = number % 10;
            String placeholder="";
            if (carryCount == 8) {
                placeholder = placeholders[5];
                carryCount = 0;
            } else if(cur!=0)placeholder = placeholders[carryCount % 5];
            result = chineseNunmber[Long.valueOf(cur).intValue()] + placeholder + result;
            number /= 10;
            carryCount++;
        }
        System.out.println(result);
        boolean isPreZero = false;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(transform(in.nextLong()));
    }
}

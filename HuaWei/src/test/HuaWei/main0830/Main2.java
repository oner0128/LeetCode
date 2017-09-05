package test.HuaWei.main0830;

import java.util.Scanner;

/**
 * Created by rrr on 2017/8/30.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num = scanner.nextLine();

            boolean isChar = false;

            if (Character.isLetter(num.charAt(0))) isChar = true;

            if (isChar) {
                //ee
                if (num.length() > 6) {
                    System.out.println("ERROR");
                    return;
                }
                int i = 0;
                int res = 0;
                while (i < num.length()) {
                    int n = num.charAt(i++) - 'a' + 1;
                    //ERROR
                    if (n > 26 || n < 1) {
                        System.out.println("ERROR");
                        return;
                    }

                    res = res * 26 + n;
                }
                System.out.println(res);
            } else {

                int number = Integer.parseInt(num);

                if (number <= 0 || number > 321272406) {
                    System.out.println("ERROR");
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                while (number > 0) {
                    number -= 1;
                    int mod = number % 26;
                    number /= 26;
                    stringBuilder.insert(0, (char) (mod  +'a'));
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }
}

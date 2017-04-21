package test.HuaWei;

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class Poker {
    public static void main(String[] args) {
        String value="345678910JQKA2";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split("-");
            String str1 = str[0];
            String str2 = str[1];
            //大小王
            if (str1.contains("joker JOKER") || str2.contains("joker JOKER")) {
                System.out.println("joker JOKER");
                return;
            }
            String[] poker1 = str1.split(" ");
            String[] poker2 = str2.split(" ");
            //炸弹
            if (poker1.length == 4 || poker2.length == 4) {
                if (poker1.length == 4 && poker2.length == 4) {
                    if (value.indexOf(poker1[0])>value.indexOf(poker2[0])) System.out.println(str1);
                    else System.out.println(str2);
                }else if (poker1.length == 4)System.out.println(str1);
                else System.out.println(str2);
                return;
            }
            //顺子，三个，对子，一个
            if (poker1.length ==poker2.length ) {
                if (value.indexOf(poker1[0])>value.indexOf(poker2[0])) System.out.println(str1);
                else System.out.println(str2);
                return;
            }
            else System.out.println("ERROR");
        }
    }
}

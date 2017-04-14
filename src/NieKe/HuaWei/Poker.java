package NieKe.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split("-");
            String[] str1 = str[0].split(" ");
            int[] poker1=new int[str1.length];
            String[] str2 = str[1].split(" ");
            int[] poker2=new int[str2.length];
            for (int i = 0; i < poker1.length; i++) {
                if (str1[i].equals("JOKER"))poker1[i]=17;
                else if (str1[i].equals("joker"))poker1[i]=16;
                else if (str1[i].equals("2"))poker1[i]=15;
                else if (str1[i].equals("A"))poker1[i]=14;
                else if (str1[i].equals("K"))poker1[i]=16;
                else if (str1[i].equals("Q"))poker1[i]=12;
                else if (str1[i].equals("J"))poker1[i]=11;
                else poker1[i]=Integer.parseInt(str1[i]);
            }
            for (int i = 0; i < poker2.length; i++) {
                if (str2[i].equals("JOKER"))poker2[i]=17;
                else if (str2[i].equals("joker"))poker2[i]=16;
                else if (str2[i].equals("2"))poker2[i]=15;
                else if (str2[i].equals("A"))poker2[i]=14;
                else if (str2[i].equals("K"))poker2[i]=16;
                else if (str2[i].equals("Q"))poker2[i]=12;
                else if (str2[i].equals("J"))poker2[i]=11;
                else poker2[i]=Integer.parseInt(str2[i]);
            }
            Arrays.sort(poker1);Arrays.sort(poker2);
            boolean[]poker1s=new boolean[6];
            boolean[]poker2s=new boolean[6];
            for (int i = 0; i < 6; i++) {
                if (str[0].contains("JOKER")&&str[0].contains("joker"))poker1s[i]=true;
//                else if (poker1)poker1s[i]=true;
            }
        }
    }
}

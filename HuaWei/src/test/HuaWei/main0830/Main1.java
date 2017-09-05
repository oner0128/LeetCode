package test.HuaWei.main0830;

import java.util.Scanner;

/**
 * Created by rrr on 2017/8/30.
 */
public class Main1 {
    static String[] numZH = new String[]{"Ling", "Yi", "Er", "San", "Si", "Wu", "Liu", "Qi", "Ba", "Jiu"};
    static String[] numEN = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static String findZH = "LYESWLQBJ";
    static String findEN = "ZOTTFFSSEN";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String num = scanner.nextLine();
            boolean isZh = false;
            boolean isDouble = false;
            int i = 0;
            if (num.charAt(0) == 'D') {
                isDouble = true;
                num = num.substring(6, num.length());
            }
            if (findZH.indexOf(num.charAt(0)) > -1) {
                if (num.charAt(1) == 'i' && num.charAt(2) == 'x') isZh = false;
                else if (num.charAt(1) == 'e') isZh = false;
                else isZh = true;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < num.length()) {
                if (num.charAt(i) == 'D') {
                    isDouble = true;
                    i += 6;
                } else if (isZh) {
                    int index = findZH.indexOf(num.charAt(i));

                    if (index == 3) {
                        if (num.charAt(i + 1) == 'i' && num.charAt(i + 2) == 'x') index = -1;
                        else if (num.charAt(i + 1) == 'e') index = -1;
                        else if (num.charAt(i + 1) == 'i') index += 1;
                    }
                    if (index == -1) {
                        System.out.println("ERROR");
                        return;
                    }
                    stringBuilder.append(numEN[index]);
                    if (isDouble) {
                        stringBuilder.append(numEN[index]);
                        isDouble = false;
                    }
                    if (index == 0 || index == 4 || index == 8) i += 4;
                    else if (index == 3 || index == 6 || index == 9) i += 3;
                    else i += 2;
                } else {//输入为英文
                    int index = findEN.indexOf(num.charAt(i));

                    if (index == 2 || index == 3) {//two or three
                        if (num.charAt(i + 1) == 'h') index += 1;
                    }
                    if (index == 4 || index == 5) {//four or five
                        if (num.charAt(i + 1) == 'i') index += 1;
                    }
                    if (index == 6 || index == 7) {//six or seven
                        if (num.charAt(i + 1) == 'i' && num.charAt(i + 1) == 'x') ;
                        else if (num.charAt(i + 1) == 'e') index += 1;
                        else index = -1;
                    }
                    if (index == -1) {
                        System.out.println("ERROR");
                        return;
                    }
                    stringBuilder.append(numZH[index]);
                    if (isDouble) {
                        stringBuilder.append(numZH[index]);
                        isDouble = false;
                    }
                    if (index == 0 || index == 4 || index == 5 || index == 9) i += 4;
                    else if (index == 1 || index == 2 || index == 6) i += 3;
                    else i += 5;
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}

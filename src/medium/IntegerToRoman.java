package medium;

/**
 * Created by rrr on 2017/4/19.
 * 12. Integer to Roman
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    //111ms
    public static String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        String roman = "IVXLCDM";
        int[] ints = {1, 5, 10, 50, 100, 500, 1000};
        for (int i = ints.length - 1; i >= 0; i--) {
            if (i % 2 == 1 && ((num + (ints[i - 1])) / ints[i + 1]) >= 1) {
                stringBuilder.append(roman.charAt(i - 1));
                stringBuilder.append(roman.charAt(i + 1));
                num = num % ints[i-1];
            } else {
                int tmp = num / ints[i];
                if (tmp < 4)
                    for (int j = 0; j < tmp; j++) {
                        stringBuilder.append(roman.charAt(i));
                    }
                else {
                    stringBuilder.append(roman.charAt(i));
                    stringBuilder.append(roman.charAt(i + 1));
                }
                num = num % ints[i];
            }
        }
        return stringBuilder.toString();
    }
    //LeetCode 解法 111ms
    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
    //LeetCode 解法 86ms beats 97%
    public String intToRoman3(int num) {

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
}

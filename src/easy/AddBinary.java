package easy;

/**
 * Created by rrr on 2017/4/18.
 * 67. Add Binary
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
//        char[] chars1 = a.toCharArray();
//        char[] chars2 = b.toCharArray();
//        int len1 = chars1.length , len2 = chars2.length ;
//        int[] num1 = new int[len1];
//        int[] num2 = new int[len2];
//        for (int i = 0; i < len1; i++) {
//            num1[i]=chars1[i]-'0';
//        }
//        for (int i = 0; i < len2; i++) {
//            num2[i]=chars2[i]-'0';
//        }
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        int len1 = num1.length - 1, len2 = num2.length - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (len2 >= 0) {
            int digit = num1[len1--] + num2[len2--] + carry - 96;
            carry = digit >= 2 ? 1 : 0;
            stringBuilder.insert(0, digit % 2);
        }
        while (len1 >= 0) {
            int digit = num1[len1--] + carry - 48;
            carry = digit >= 2 ? 1 : 0;
            stringBuilder.insert(0, digit % 2);
        }
        if (carry == 1) return stringBuilder.append(1).toString();
        return stringBuilder.toString();
    }

    public static String addBinary2(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        char[] num1 = a.toCharArray();
        char[] num2 = b.toCharArray();
        int len1 = num1.length - 1, len2 = num2.length - 1;
        int carry = 0;
        while (len2 >= 0) {
            int digit = num1[len1] + num2[len2--] + carry - 96;
            carry = digit >= 2 ? 1 : 0;
            num1[len1--] = digit % 2 == 1 ? '1' : '0';
        }
        while (carry == 1 && len1 >= 0) {
            int digit = num1[len1] + carry - 48;
            carry = digit >= 2 ? 1 : 0;
            num1[len1--] = digit % 2 == 1 ? '1' : '0';
        }
        if (carry == 1)
            return new StringBuilder(new String(num1)).insert(0, 1).toString();
        return new String(num1);
    }
    //LeetCode解法
    public String addBinary3(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11111", "11"));
    }
}

package medium;

/**
 * Created by rrr on 2017/4/19.
 * 43. Multiply Strings
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.length()< num2.length()) return multiply(num2, num1);
        char[] digit1 = num1.toCharArray();
        char[] digit2 = num2.toCharArray();
        if (digit2.length == 1 && digit2[0] == '0') return "0";
        int[] res = new int[digit1.length + digit2.length];
        int[] sum;
        for (int i = digit2.length - 1; i >= 0; i--) {
            int two = digit2[i] - '0';
            int index1 = digit1.length - 1;
            int carry = 0;
            int index = res.length - 1;
            sum = new int[digit1.length + digit2.length];
            while (index1 >= 0) {
                int one = digit1[index1--] - '0';
                int pro = one * two + carry;
                int mod = pro % 10;
                carry = pro / 10;
                sum[index--- digit2.length + i + 1] = mod;
            }
            if (carry > 0) sum[index-- - digit2.length + i + 1] = carry;
            index = res.length - 1;
            carry = 0;
            while (index >= 0) {
                int tmp1 = sum[index];
                int tmp2 = res[index];
                int pro = tmp1 + tmp2 + carry;
                int mod = pro % 10;
                carry = pro / 10;
                res[index--] = mod;
            }
        }
        String str = "";
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            str = str + res[i];
        }
        return str;
    }
    //LeetCode大神解法
    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply2("123", "456"));
        System.out.println(new MultiplyStrings().multiply("0", "4562"));
    }
}

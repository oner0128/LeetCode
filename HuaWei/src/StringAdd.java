import java.util.Scanner;

/**
 * Created by rrr on 2017/6/27.
 * 题目描述
 在计算机中，由于处理器位宽限制，只能处理有限精度的十进制整数加减法，比如在32位宽处理器计算机中，
 参与运算的操作数和结果必须在-231~231-1之间。如果需要进行更大范围的十进制整数加法，需要使用特殊
 的方式实现，比如使用字符串保存操作数和结果，采取逐位运算的方式。如下：
 9876543210 + 1234567890 = ?
 让字符串 num1="9876543210"，字符串 num2="1234567890"，结果保存在字符串 result = "11111111100"。
 -9876543210 + (-1234567890) = ?
 让字符串 num1="-9876543210"，字符串 num2="-1234567890"，结果保存在字符串 result = "-11111111100"。
 */
public class StringAdd {
    private static final long LONG_MASK = 0xffffffffL;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int i = s1.length() - 1, j = s2.length() - 1;
            boolean isNegative = isNegetive(s1, s2);
            boolean isAdd = isAdd(s1, s2);
            StringBuilder result = new StringBuilder();
            if (isAdd) {//a+b
                int carry = 0;
                while (i >= 0 || j >= 0) {
                    int a = i >= 0 ? (chars1[i] != '-' ? chars1[i] - '0' : 0) : 0;
                    int b = j >= 0 ? (chars2[j] != '-' ? chars2[j] - '0' : 0) : 0;
                    int cur = a + b + carry;
                    carry = cur / 10;
                    cur %= 10;
                    result.insert(0, cur);
                    i--;
                    j--;
                }
                while (result.charAt(0) == '0') result.deleteCharAt(0);
                if (carry==1)result.insert(0, carry);
                if (isNegative) result.insert(0, '-');
                System.out.println(result.toString());
            } else {//a-b
                int cmp = compareMagnitude(s1, s2);
                if (cmp == 0) {
                    System.out.println("0");
                    return;
                }
                if (cmp < 0) {
                    String tmp = s1;
                    s1 = s2;
                    s2 = tmp;
                }
                int carry = 0;
                while (i >= 0 || j >= 0) {
                    int a = i >= 0 ? (chars1[i] != '-' ? chars1[i] - '0' : 0) : 0;
                    int b = (j >= 0 ? (chars2[j] != '-' ? chars2[j] - '0' : 0) : 0)+carry;
                    carry = a<b?1:0;
                    a=a<b?a+10:a;
                    int cur = a - b;
                    result.insert(0, cur);
                }
                while (result.charAt(0) == '0') result.deleteCharAt(0);
                if (isNegative) result.insert(0, '-');
                System.out.println(result.toString());
            }
        }
    }

    private static boolean isAdd(String s1, String s2) {
        if (s1.charAt(0) == '-' && s2.charAt(0) == '-') return true;
        if (s1.charAt(0) != '-' && s2.charAt(0) != '-') return true;
        return false;
    }

    private static int compareMagnitude(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 < len2)
            return -1;
        if (len1 > len2)
            return 1;
        for (int i = 0; i < len1; i++) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';
            if (a != b)
                return ((a & LONG_MASK) < (b & LONG_MASK)) ? -1 : 1;
        }
        return 0;
    }

    private static boolean isNegetive(String s1, String s2) {
        if (s1.charAt(0) == '-' && s2.charAt(0) == '-') return true;
        if (s1.charAt(0) != '-' && s2.charAt(0) != '-') return false;
        if (s1.charAt(0) == '-') {
            if (s1.length() - 1 > s2.length()) return true;
            else if (s1.length() - 1 < s2.length()) return false;
            int lo = 0;
            while (lo < s1.length() - 1) {
                if (s1.charAt(lo + 1) - '0' > s2.charAt(lo) - '0') return true;
                else if (s1.charAt(lo + 1) - '0' < s2.charAt(lo) - '0') return false;
                lo++;
            }
            return false;
        } else {
            if (s2.length() - 1 > s1.length()) return true;
            else if (s2.length() - 1 < s1.length()) return false;
            int lo = 0;
            while (lo < s2.length() - 1) {
                if (s2.charAt(lo + 1) - '0' > s1.charAt(lo) - '0') return true;
                else if (s2.charAt(lo + 1) - '0' < s1.charAt(lo) - '0') return false;
                lo++;
            }
            return false;
        }
    }
}

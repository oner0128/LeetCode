package easy;

/**
 * Created by rrr on 2017/4/15.
 * 541. Reverse String II
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII {
    //分治算法
    public static String reverseStr(String s, int k) {
        int len = s.length();
        if (len < 2 * k) return len >= k ? reverse(s, k) : reverse(s, s.length());
        return reverse(s.substring(0, 2 * k), k) + reverseStr(s.substring(2 * k, len), k);
    }

    public static String reverse(String s, int len) {
        int lo = 0, hi = len - 1;
        char[] chars = s.toCharArray();
        while (lo < hi) {
            chars[lo] ^= chars[hi];
            chars[hi] ^= chars[lo];
            chars[lo++] ^= chars[hi--];
        }
        return new String(chars);
    }

    //迭代
    public static String reverseStr2(String s, int k) {
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
        }
        int lo=0;
        return reverse(s.substring(lo, lo + 2 * k), k) + reverseStr2(s.substring(lo + 2 * k, len), k);
    }

    public static void main(String[] args) {
        String s = "heabc";
        String s2 = "abcdefg";
        String s3 = "abcdefghijk";
        System.out.println(reverseStr(s, 2));
        System.out.println(reverseStr(s2, 2));
        System.out.println(reverseStr(s3, 3));
    }
}

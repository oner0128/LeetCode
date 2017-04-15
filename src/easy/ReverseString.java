package easy;

/**
 * Created by rrr on 2017/4/15.
 *
 * Write a function that takes a string as input and returns the string reversed.
 Example:
 Given s = "hello", return "olleh".
 */
public class ReverseString {
    //O(n) 7 ms
    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            stringBuilder.append(s.charAt(i - 1));
        }
        return stringBuilder.toString();
    }

    //O(n/2) 409ms Two Pointers
    public static String reverseString2(String s) {
        int lo = 0, hi = s.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (lo < hi) {
            stringBuilder.insert(lo, s.charAt(hi--));
            stringBuilder.insert(stringBuilder.length() - lo, s.charAt(lo++));
        }
        if (lo == hi) stringBuilder.insert(lo, s.charAt(hi));
        return stringBuilder.toString();
    }

    //O(n/2) 3ms Two Pointers
    public static String reverseString3(String s) {
        int lo = 0, hi = s.length() - 1;
        char[] chars = s.toCharArray();
        while (lo < hi) {
            chars[lo] ^= chars[hi];
            chars[hi] ^= chars[lo];
            chars[lo++] ^= chars[hi--];
        }
        return String.copyValueOf(chars);
    }
    //LeetCode解法  分治算法  24ms
    //Approach: Using Java Library
    //Java's library is probably slower that direct implementation due to extra overhead in check various edge cases such as surrogate pairs.
    // Time Complexity: `O(n log(n))` (Average Case) and `O(n * log(n))` (Worst Case) where `n` is the total number character in the input string. The recurrence equation is `T(n) = 2 * T(n/2) + O(n)`. `O(n)` is due to the fact that concatenation function takes linear time. The recurrence equation can be solved to get `O(n * log(n))`.
    //Auxiliary Space: `O(h)` space is used where `h` is the depth of recursion tree generated which is `log(n)`. Space is needed for activation stack during recursion calls.
    public String reverseString4(String s) {
        int length = s.length();
        if (length <= 1) return s;
        String leftStr = s.substring(0, length / 2);
        String rightStr = s.substring(length / 2, length);
        return reverseString4(rightStr) + reverseString4(leftStr);
    }

    public static void main(String[] args) {
        String s = "heallo";String s2 = "healo";
        System.out.println(reverseString3(s));System.out.println(reverseString3(s2));
    }
}

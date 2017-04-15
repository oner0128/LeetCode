package easy;

/**
 * Created by rrr on 2017/4/15.
 * 557. Reverse Words in a String III
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[]strings=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < strings.length - 1; i++) {
            sb.append(reverseString(strings[i])+" ");
        }
        sb.append(reverseString(strings[strings.length-1]));
        return sb.toString();

    }
    public static String reverseString(String s) {
        int lo = 0, hi = s.length() - 1;
        char[] chars = s.toCharArray();
        while (lo < hi) {
            chars[lo] ^= chars[hi];
            chars[hi] ^= chars[lo];
            chars[lo++] ^= chars[hi--];
        }
        return new String(chars);
    }
}

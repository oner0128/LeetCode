package hard;

/**
 * Created by rrr on 2017/8/30.
 * 214. Shortest Palindrome
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * For example:
 * <p>
 * Given "aacecaaa", return "aaacecaaa".
 * <p>
 * Given "abcd", return "dcbabcd".
 * <p>
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases. Thanks to @Freezen for additional test cases.
 */
public class ShortestPalindrome {
    //brute force  Time Limit Exceeded
    public String shortestPalindrome_wrong(String s) {
        int i = s.length() - 1, start = 0;
        StringBuilder stringBuilder = new StringBuilder(s);
        while (i > 0 && !isPalindrome(stringBuilder.toString())) {
            stringBuilder.insert(start++, s.charAt(i--));
        }
        return stringBuilder.toString();
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    //leetCode brute force  Time Limit Exceeded
    public String shortestPalindrome_wrong2(String s) {
        int n = s.length();
        StringBuilder reverse = new StringBuilder(s);
        reverse.reverse();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(reverse.substring(i)))
                return reverse.substring(0, i) + s;
        }
        return "";
    }

    //leetCode2  brute force find longest palindrome from index 0
    //利用三指针找到从0位置开始的最长回文
    //Time Limit Exceeded
    public String shortestPalindrome_wrong3(String s) {
        int i = 0, j = s.length() - 1, end = j;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {//重置i=0，因为需要求从0位置开始的最长回文
                i = 0;
                j = --end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

    //leetCode3   find longest palindrome from index 0
    //优化找到从0位置开始的最长回文的时间复杂度，利用了递归
    public String shortestPalindrome(String s) {
        int i = 0, n = s.length();
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) return s;
        String remain_rev = new StringBuilder(s.substring(i, n)).reverse().toString();
        return remain_rev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }

    //leetCode4   利用kmp算法扎到从0位置开始的最长回文 time O(n)
    public String shortestPalindrome2(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String pattern = s + '#' + rev;
        int[] next = new int[pattern.length()];
        for (int i = 1; i < pattern.length(); i++) {
            int index = next[i - 1];
            while (index > 0 && pattern.charAt(index) != pattern.charAt(i))
                index = next[i - 1];
            if (pattern.charAt(index) == pattern.charAt(i)) index++;
            next[i] = index + 1;
        }
        return new StringBuilder(s.substring(next[pattern.length() - 1])).reverse().toString() + s;
    }

    public static void main(String[] args) {
//        System.out.println(new ShortestPalindrome().shortestPalindrome("abcd"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome().shortestPalindrome("aabcecaaa"));
    }
}

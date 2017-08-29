package hard;

/**
 * Created by rrr on 2017/6/27.
 * 44. Wildcard Matching
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    //leetcode Greedy solution
    public static boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern when str.length()<pattern.length()
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    //leetcode dp
    public static boolean isMatch2(String str, String pattern) {
        if (str == null || pattern == null) return false;
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        //init row0
        dp[0][0]=true;
        for (int i = 1; i <=pattern.length() ; i++) {
            if (pattern.charAt(i-1)=='*')dp[0][i]=true;
            else break;
        }
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j-1)=='?'||str.charAt(i-1)==pattern.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else if (pattern.charAt(j-1)=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("caaab", "c*b"));
    }
}

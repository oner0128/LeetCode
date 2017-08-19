package hard;

/**
 * Created by rrr on 2017/8/19.
 * 10. Regular Expression Matching
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") ? false
 isMatch("aa","aa") ? true
 isMatch("aaa","aa") ? false
 isMatch("aa", "a*") ? true
 isMatch("aa", ".*") ? true
 isMatch("ab", ".*") ? true
 isMatch("aab", "c*a*b") ? true
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s==null||p==null)return false;
        boolean[][]dp=new boolean[s.length()+1][p.length()+1];
        //init row0
        dp[0][0]=true;
        for (int i = 2; i < p.length(); i++) {
            if (p.charAt(i)=='*'&&dp[0][i-2])dp[0][i]=true;
        }
        //dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1))dp[i][j]=dp[i-1][j-1];
                else if (p.charAt(j-1)=='*'){
                    if (p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.')dp[i][j]=dp[i][j-2];
                    else dp[i][j]=dp[i][j-2]||dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

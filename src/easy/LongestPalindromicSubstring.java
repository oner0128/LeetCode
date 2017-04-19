package easy;

/**
 * Created by rrr on 2017/4/19.
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring {
    //完全不会
    //LeetCode解法，以i中向两边延展计算回文最大长度，分长度是奇偶两种情况
    public String longestPalindrome(String s) {
        int start=0,end=0;
        for (int i = 0; i < s.length(); i++) {
            int len1=extendAroundCenter(s,i,i);//子字符串长度是奇数 aba
            int len2=extendAroundCenter(s,i,i+1);//偶数 abba
            int len=Math.max(len1,len2);
            if (len>end-start){
                start=i-(len-1)/2;//1.abba,i=1,start=1-(4-1)/2=0 ;2.aba,i=1,start=1-(3-1)/2=0
                end=i+len/2;//1.abba,i=1,end=1+4/2=3 ;2.aba,i=1,end=1+3/2=2
            }
        }
        return s.substring(start,end+1);
    }

    private int extendAroundCenter(String s, int left, int right) {
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){left--;right++;}
        return right-left-1;//关键
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}

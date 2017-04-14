import java.util.HashMap;
import java.util.Map;

/**
 * Created by hrong on 2017/1/6.
 * LeetCode 3rd
 * 提示：Hash Table Two Pointers String
 * 错误思路：若相邻两字符相同，则重新计数并将之前子序列（大于1）记录在maxLength中，但是在"abcabcbb"中发生错误，输出为abcabcb，
 * 正确应为abc
 * 正确：利用HashMap的contain方法快速查找是否出现重复字符
 */
// 自己独立完成但是时间复杂度无法通过。原因，只利用了HashMap中的Key没有有效利用value
// 自己思路：head/end两点当遇到重复字符时计算head/end差值，若大于已有length则更新
//正确思路：head/end两点在没有重复字符前一直不断计算head/end差值并更新最大length，当下一字符已存在于之前子字符串时将head的值置为子字符串序号的下一位。
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, maxBegin = 0, maxEnd = 0, maxLength = 0,tmpLength;
        Map<Character, Integer> subStrings = new HashMap<>();
        while (j < s.length()) {
            if (!subStrings.containsKey(s.charAt(j))) {//若HashMap中无相同两字符，则该字符放入HashMap中
                subStrings.put(s.charAt(j), j++);
                if (j==s.length()&&(j - i > maxLength)) {
                    maxLength = j - i;
                    maxEnd = j;
                    maxBegin = i;
                }
            } else {//若HashMap中已存在该字符，则重新计数并按情况将之前一个字符重新放入HashMap中
                if ((tmpLength=j - i )> maxLength) {
                    maxLength =tmpLength;
                    maxEnd = j;
                    maxBegin = i;
                }
                if (j-1==i)i=j;
                else j=++i;
                subStrings.clear();
                subStrings.put(s.charAt(j), j++);
            }
        }
        System.out.println(s.substring(maxBegin, maxEnd));
        return maxLength;
    }
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] ss={"pwwkew","abcabcbb","bbbbb","babcd","anviaj","ohvhjdml",""};
        for (String s:ss) System.out.println(lengthOfLongestSubstring(s));
    }
}
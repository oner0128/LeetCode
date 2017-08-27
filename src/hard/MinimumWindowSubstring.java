package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/8/27.
 * 76. Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    //61 ms beat 12%
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int left = 0, leftMin = 0, rightMin = 0, count = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (countMap.size() == 0) left = i;
                countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
                if (countMap.get(s.charAt(i)) <= map.get(s.charAt(i))) count++;

                if (count == t.length()) {
                    while (count >= t.length()) {//删除窗口最左边一个字符后，看是否还满足条件
                        if (rightMin==0||rightMin - leftMin-1 >= i - left) {
                            rightMin = i+1;
                            leftMin = left;
                        }
                        countMap.put(s.charAt(left), countMap.get(s.charAt(left)) - 1);
                        if (countMap.get(s.charAt(left)) < map.get(s.charAt(left))) count--;
                        left++;
                        while (left<=i&&!countMap.containsKey(s.charAt(left)))left++;
                    }
                }
            }
        }
        return s.substring(leftMin, rightMin);
    }
    //leetCode解法 使用数组  3 ms beat 97%
    public String minWindow2(String s, String t) {
        if (s == null || s.length() == 0) return "";
        int[]map=new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int begin = 0, end = 0, head = 0, count = t.length(),minSize=Integer.MAX_VALUE;
        while (end<s.length()){
            if (map[s.charAt(end++)]-->0)count--;
            while (count==0){
                if (end-begin<=minSize)minSize=end-(head=begin);
                if (map[s.charAt(begin++)]++==0)count++;
            }
        }
        return minSize==Integer.MAX_VALUE?"":s.substring(head, head+minSize);
    }
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow2("ADOBCECODEBANAC",
                "ABC"));
        System.out.println(new MinimumWindowSubstring().minWindow2("ADOBECODEBANAC",
                "ABCAAF"));
        System.out.println(new MinimumWindowSubstring().minWindow2("a",
                "a"));

        System.out.println(new MinimumWindowSubstring().minWindow2("bba",
                "ab"));
        System.out.println("abc".substring(0,2));
    }
}

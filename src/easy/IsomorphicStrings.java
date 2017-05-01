package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/4/28.
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length() ) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {if(!map.get(s.charAt(i)).equals(t.charAt(i)))return false;}//若存在pattern[i]且对应的str与str[i]不相等,则不匹配
            else if (map.containsValue(t.charAt(i))) return false;//若不存在pattern[i]但是存在str[i]说明pattern[0..n-1]的某个存在的str为str[i],不匹配
            else map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
    //The main idea is to store
    // the last seen positions of current (i-th) characters in both strings.
    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}

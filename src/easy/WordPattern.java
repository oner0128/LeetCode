package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/4/10.
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        String[] s = str.split(" ");
        if (patterns.length != s.length || pattern.length() == 0 || str.length() == 0) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i])) {if(!map.get(patterns[i]).equals(s[i]))return false;}//若存在pattern[i]且对应的str与str[i]不相等,则不匹配
            else if (map.containsValue(s[i])) return false;//若不存在pattern[i]但是存在str[i]说明pattern[0..n-1]的某个存在的str为str[i],不匹配
            else map.put(patterns[i], s[i]);
        }
        return true;
    }
    //LeetCode解法
    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}

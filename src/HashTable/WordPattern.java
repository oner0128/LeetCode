package HashTable;

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
        if (patterns.length!=s.length||pattern.length() == 0 || str.length() == 0)return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (map.containsKey(patterns[i])||map.containsValue(s[i])) {
                if (!map.get(patterns[i]).equals(s[i])) return false;
            } else map.put(patterns[i], s[i]);
        }
        return true;
    }
}

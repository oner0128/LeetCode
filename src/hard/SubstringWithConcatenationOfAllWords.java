package hard;

import java.util.*;

/**
 * Created by rrr on 2017/8/8.
 * 30. Substring with Concatenation of All Words
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * <p>
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringWithConcatenationOfAllWords {
    //失败
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return res;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        int wordLength = words[0].length();
        int wordNums = words.length;
        for (int i = 0; i < wordLength; i++) {
            int hasContain = 0;
            int left = i;
            Map<String, Integer> hasMap = new HashMap<>();
            for (int j = i; j + wordLength <= s.length(); j += wordLength) {
                String substr = s.substring(j, j + wordLength);
                //valid str
                if (map.containsKey(substr)) {
                    if (hasMap.containsKey(substr)) hasMap.put(substr, hasMap.get(substr) + 1);
                    else hasMap.put(substr, 1);
                    //检查已有str个数
                    if (hasMap.get(substr) <= map.get(substr)) hasContain++;
                    else {//包含str的个数超出word中对应的，需将窗右移一个str长度,并将该str在hasMap中的个数减一
//                        "wordgoodgoodgoodbestword"
//                                ["word","good","best","good"] 此情况就需要循环右移窗,若之右移一次无法移除"good"，移除的是"word"
                        while (hasMap.get(substr) > map.get(substr)) {
                            String leftStr = s.substring(left, left + wordLength);
                            if (hasMap.containsKey(leftStr)) hasMap.put(leftStr, hasMap.get(leftStr) - 1);
                            if (hasMap.get(leftStr) < map.get(leftStr)) hasContain--;
                            left += wordLength;
                        }
                    }

                    if (hasContain == wordNums) {//找到序列，窗右移一个wordLength长度
                        res.add(left);
                        String leftStr = s.substring(left, left + wordLength);
                        hasMap.put(leftStr, hasMap.get(leftStr) - 1);
                        hasContain--;
                        left += wordLength;
                    }
                }
                //non-valid str
                else {
                    left = j + wordLength;//不是 left += wordLength;因为当遇到无根据str时，前面的窗都作废
                    hasMap.clear();
                    hasContain = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}

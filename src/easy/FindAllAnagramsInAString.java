package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrr on 2017/8/28.
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    //sliding window
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        if (s.length()<p.length())return res;
        int[]strMap=new int[26];
        int[]patternMap=new int[26];
        for (int i = 0; i < p.length(); i++) {
            strMap[s.charAt(i)-'a']++;
            patternMap[p.charAt(i)-'a']++;
        }
        int count=0;
        for (int i = 0; i < 26; i++) {
            if (strMap[i]==patternMap[i])count++;
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (count==26)res.add(i);
            int left=s.charAt(i)-'a',right=s.charAt(i+p.length())-'a';
            //add new element to the right of window
            strMap[right]++;
            if (strMap[right]==patternMap[right])count++;
            else if (strMap[right]==patternMap[right]+1)count--;
            //remove old element in the left of window
            strMap[left]--;
            if (strMap[left]==patternMap[left])count++;
            else if (strMap[left]==patternMap[left]-1)count--;
        }
        if (count==26)res.add(s.length() - p.length());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams("cbaebabacb",
                "abc"));
    }
}

package easy;

import java.util.*;

/**
 * Created by rrr on 2017/4/10.
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    //bit mani
    //错误答案
   /* Input:
            "aa"
            "bb"
    Output:
            true
    Expected:
            false*/
    public boolean isAnagram(String s, String t) {
        int sum = 0;
        for (char c : s.toCharArray()) sum ^= c;
        for (char c : t.toCharArray()) sum ^= c;
        return sum == 0 ? true : false;
    }
    //bucket 4ms
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[]bucket1=new int[128];int[]bucket2=new int[128];
        for (char c:s.toCharArray())bucket1[c]+=1;
        for (char c:t.toCharArray())bucket2[c]+=1;
        for (int i = 0; i < bucket1.length; i++) {
            if (bucket2[i]!=bucket1[i])return false;
        }
        return true;
    }
    //bucket 优化桶长度到26 4ms
    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[]bucket1=new int[26];int[]bucket2=new int[26];
        for (char c:s.toCharArray())bucket1[c-'a']+=1;
        for (char c:t.toCharArray())bucket2[c-'a']+=1;
        for (int i = 0; i < bucket1.length; i++) {
            if (bucket2[i]!=bucket1[i])return false;
        }
        return true;
    }
    //LeetCode大神解法 6ms
    public boolean isAnagram4(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
    //bucket 优化 3ms
    //Yeah!!!You are here!
//    Your runtime beats 96.49% of java submissions.
    public boolean isAnagram5(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[]bucket=new int[26];
        for (char c:s.toCharArray())bucket[c-'a']+=1;
        for (char c:t.toCharArray())bucket[c-'a']-=1;
        for (int i :bucket) {
            if (i!=0)return false;
        }
        return true;
    }
}

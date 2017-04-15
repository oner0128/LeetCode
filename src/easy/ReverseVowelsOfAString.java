package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rrr on 2017/4/15.
 * 345. Reverse Vowels of a String
 * Write a function that takes a string as input
 * and reverse only the vowels of a string.
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    //O(n/2) 5ms Two Pointers
    public static String reverseVowels(String s) {
        int lo = 0, hi = s.length() - 1;
        String Vowels = "aiueoAIUEO";
        char[] chars = s.toCharArray();
        while (lo < hi) {
            while (lo < hi && Vowels.indexOf(chars[lo]) == -1)
                lo++;
            while (lo < hi && Vowels.indexOf(chars[hi]) == -1)
                hi--;
            if (lo >= hi) break;
            chars[lo] ^= chars[hi];
            chars[hi] ^= chars[lo];
            chars[lo++] ^= chars[hi--];
        }
        return new String(chars);
    }

    //LeetCode 利用HashSet
    // O(n/2) 11ms Two Pointers
    public static String reverseVowels2(String s) {
        int lo = 0, hi = s.length() - 1;
        String Vowels = "aiueoAIUEO";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < Vowels.length(); i++)
            set.add(Vowels.charAt(i));
        char[] chars = s.toCharArray();
        while (lo < hi) {
            while (lo < hi && !set.contains(chars[lo]))
                lo++;
            while (lo < hi && !set.contains(chars[hi]))
                hi--;
            if (lo >= hi) break;
            chars[lo] ^= chars[hi];
            chars[hi] ^= chars[lo];
            chars[lo++] ^= chars[hi--];
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        String s2 = "leetcode";
        String s3 = "aA";
        System.out.println(reverseVowels2(s));
        System.out.println(reverseVowels2(s2));
        System.out.println(reverseVowels2(s3));
    }
}

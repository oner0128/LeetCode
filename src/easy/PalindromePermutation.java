package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/7/8.
 * 266 Palindrome Permutation
 * <p>
 * Given a string, determine if a permutation of the string could form a palindrome.
 * <p>
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * <p>
 * Hint:
 * <p>
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class PalindromePermutation {
    //回文中只允许有一个字母的个数为奇数，即ABA型
    public static boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int[]count=new int[256];
        int odd=0;
        for (int i = 0; i < s.length(); i++)
           odd+=++count[s.charAt(i)]%2==1?1:-1;
        return odd<=1;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("aab"));
    }
}

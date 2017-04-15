package easy;

/**
 * Created by rrr on 2017/4/15.
 * 520. Detect Capital
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase
 * and lowercase latin letters.
 */
public class DetectCapital {
    //46ms 思路利用ASCII将字符判断为大写或小写
    public static boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        char[] chars = word.toCharArray();
        int num = chars[0] >= 97 ? 97 : 65;
        for (int i = 1; i < chars.length; i++) {
            if (i != 1 && num == 65 && chars[i] >= 97) return false;
            if (chars[i] - num < 0) return false;
            num = chars[i] >= 97 ? 97 : 65;
        }
        return true;
    }

    // 思路：1.当word[0]是小写字符，则剩余所有字符必须全为小写字母才为真
    //       2当word[0]是大写字符，则剩余所有字符必须全为小写或大写才为真
    //        由此，先判断第一和第二个字符，剩余字符只需判断是否相同即可
    // 34 ms 空间O(n)
    public static boolean detectCapitalUse2(String word) {
        if (word.length() < 2) return true;
        char[] chars = word.toCharArray();
        int one = chars[0] >= 97 ? 97 : 65;
        int two = chars[1] >= 97 ? 97 : 65;
        if (one > two) return false;
        for (int i = 2; i < chars.length; i++)
            if ((chars[i] >= 97 ? 97 : 65) != two) return false;
        return true;
    }
    //思路同上但是不使用char[]
    // 29 ms ms 空间O(1)
    public static boolean detectCapitalUse3(String word) {
        if (word.length() < 2) return true;
        int one = word.charAt(0) >= 97 ? 97 : 65;
        int two = word.charAt(1) >= 97 ? 97 : 65;
        if (one > two) return false;
        for (int i = 2; i < word.length(); i++)
            if ((word.charAt(i) >= 97 ? 97 : 65) != two) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(detectCapitalUse2("FlaG"));
        System.out.println(detectCapitalUse2("FJKLADS"));
        System.out.println(detectCapitalUse2("FAAAAAAa"));
        System.out.println(detectCapitalUse2("Faaaaaa"));
        System.out.println(detectCapitalUse3("waHaha"));
    }
}

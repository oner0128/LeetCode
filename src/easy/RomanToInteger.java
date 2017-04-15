package easy;

/**
 * Created by rrr on 2017/4/15
 * Roman to Integer
 * 13. Roman to Integer Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 141235
 * Total Submissions: 316348
 * Difficulty: Easy
 * Contributor: LeetCode
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999..
 */
public class RomanToInteger {
    //94 ms
    public static int romanToInt(String s) {
        String roman = "IVXLCDM";
        int[] ints = {1, 5, 10, 50, 100, 500, 1000};
        int reduce = 0, add = 0,tmp;
        for (int i = 0; i < s.length(); i++) {
            tmp=roman.indexOf(s.charAt(i));
            if (i < s.length() - 1 && tmp < roman.indexOf(s.charAt(i+1))) reduce -= ints[tmp];
            else add += ints[tmp];
        }
        return reduce + add;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MDLXVIII"));
    }
}

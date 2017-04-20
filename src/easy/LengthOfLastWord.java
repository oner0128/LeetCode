package easy;

/**
 * Created by rrr on 2017/4/18.
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 If the last word does not exist, return 0.
 Note: A word is defined as a character sequence consists of non-space characters only.
 For example,
 Given s = "Hello World",
 return 5.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length()==0||s==null)return 0;
        String[]str=s.split(" ");
        if (str.length==0)return 0;
        return str[str.length-1].length();
    }
    //LeetCode解法 trim()方法只会去除两边的' ',中间不会去除
    public int lengthOfLastWord2(String s) {
        System.out.println(s.trim().length());
        System.out.println(s.trim().lastIndexOf(" "));
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
    public static void main(String[] args) {
//        System.out.println(new LengthOfLastWord().lengthOfLastWord("asdsadas "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2("asdsadas "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2(" "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2(" "));
    }
}

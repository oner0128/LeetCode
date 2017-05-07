/**
 * Created by rrr on 2017/5/7.
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    //利用正则表达来切分字符串无法解决某一段字符串是一段空格的情况
    public static String ReverseSentence(String str) {
        if (str.length() == 0 || str == null) return "";
        String[] strings = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            sb.append(strings[i] + " ");
        }
        return sb.toString();
    }

    //思路:翻转字符串,先翻转整个字符串,再逐个翻转某个词
    public static String ReverseSentence2(String str) {
        if (str.length() == 0 || str == null) return "";
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int i = 0, j = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                i++;
                j++;
            } else if (chars[j] == ' ' || j == chars.length - 1) {
                int end = j == chars.length - 1 ? j : j - 1;
                reverse(chars, i, end);
                i = ++j;
            } else j++;
        }
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        if (start >= end) return;
        while (start < end) {
            chars[start] ^= chars[end];
            chars[end] ^= chars[start];
            chars[start] ^= chars[end];
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence2("I am a student."));
        System.out.println(ReverseSentence2("Wonderful"));
    }
}

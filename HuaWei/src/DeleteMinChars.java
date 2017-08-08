import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by rrr on 2017/8/7.
 * 删除字符串中出现次数最少的字符
 * <p>
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 * 示例1
 * 输入
 * <p>
 * abcdd
 * 输出
 * <p>
 * dd
 */
public class DeleteMinChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] chars = scanner.next().toLowerCase().toCharArray();
            int[] freq = new int[26];
            for (char c : chars) freq[c - 97]++;//统计频率
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {//找到频率最小值
                if (freq[i] != 0 && freq[i] < min) min = freq[i];
            }
            Set<Character> minChars = new HashSet<>();
            for (int i = 0; i < 26; i++) //找到频率最小值的字符，可能有一个或多个
                if (freq[i] != 0 && freq[i] == min) minChars.add((char) (i + 97));
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : chars) if (!minChars.contains(c)) stringBuilder.append(c);//输出字符
            System.out.println(stringBuilder.toString());
        }
        scanner.close();
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[] chars = scanner.next().toLowerCase().toCharArray();
            int[] freq = new int[26];
            int min = Integer.MAX_VALUE;
            for (char c : chars) {//统计频率,并统计频率最小值
                freq[c - 'a']++;
                min = min > freq[c - 'a'] ? freq[c - 'a'] : min;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : chars) if (freq[c - 'a'] != min) stringBuilder.append(c);//输出字符
            System.out.println(stringBuilder.toString());
        }
        scanner.close();
    }
}

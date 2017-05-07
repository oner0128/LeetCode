import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrr on 2017/5/6.
 * 题目描述
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。如果字符串为空,返回-1
 */
public class FirstNotRepeatingChar {
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        int[] map = new int[256];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
            map[str.charAt(i) + 128] = i;
        }
        int min = str.length() - 1;
        for (int i = 0; i < str.length(); i++)
            if (map[str.charAt(i)] == 1 && map[str.charAt(i) + 128] < min) min = map[i + 128];
        return min;
    }
    //代码优化,不需要256大小的数组来记录字符的位置
    public static int FirstNotRepeatingChar2(String str) {
        if (str == null || str.length() == 0) return -1;
        int[] map = new int[128];
        for (int i = 0; i < str.length(); i++) {
            map[str.charAt(i)]++;
        }
        int min = str.length() - 1;
        for (int i = 0; i < str.length(); i++)
            if (map[str.charAt(i)] == 1 ) return min = i;
        return min;
    }
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("googgle"));
    }
}

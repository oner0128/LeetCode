import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by rrr on 2017/6/27.
 * 题目描述
 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 要求：
 实现如下2个通配符：
 *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 ？：匹配1个字符

 输入：
 通配符表达式；
 一组字符串。

 输出：
 返回匹配的结果，正确输出true，错误输出false
 */
public class StringMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String pattern = scanner.nextLine();
            String str = scanner.nextLine();
            System.out.println(isMatch(str,pattern));
        }
    }

    private static boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}

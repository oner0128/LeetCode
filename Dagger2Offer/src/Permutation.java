import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by rrr on 2017/5/6.
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) return res;
        char[] chars = str.toCharArray();
        TreeSet<String> set=new TreeSet<>();
        helper(set, chars, 0);
        res.addAll(set);
        return res;
    }

    private static void helper(TreeSet<String> res, char[] chars, int start) {
        if (start > chars.length - 1)
           return;
        if (start == chars.length - 1)
            res.add(new String(chars));
        else for (int i = start; i <= chars.length-1; i++) {
            char tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
            helper(res, chars, start + 1);
            tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
        }
    }
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> result = new ArrayList<String>() ;
        if(str==null || str.length()==0) { return result ; }

        char[] chars = str.toCharArray() ;
        TreeSet<String> temp = new TreeSet<>() ;
        Permutation2(chars, 0, temp);
        result.addAll(temp) ;
        return result ;
    }

    public void Permutation2(char[] chars, int begin, TreeSet<String> result) {
        if(chars==null || chars.length==0 || begin<0 || begin>chars.length-1) { return ; }

        if(begin == chars.length-1) {
            result.add(String.valueOf(chars)) ;
        }else {
            for(int i=begin ; i<=chars.length-1 ; i++) {
                swap(chars, begin, i) ;

                Permutation2(chars, begin+1, result);

                swap(chars, begin, i) ;
            }
        }
    }

    public void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
    public static void main(String[] args) {
        System.out.println(Permutation("abc"));
        System.out.println(new Permutation().Permutation2("abc"));
    }
}

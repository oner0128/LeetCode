package easy;

import com.sun.deploy.net.HttpRequest;

/**
 * Created by rrr on 2017/4/16.
 * 28. Implement strStr()
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStr {
    //暴力算法 15ms
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        for (; i < haystack.length()&j<needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == needle.length()) return i-j;
        else return -1;
    }
    //KMP
    public static int strStr2(String haystack, String needle) {
        //KMP algorithms
        if(needle.equals("")) return 0;
        if(haystack.equals("")) return -1;
        char[] arr = needle.toCharArray();

        int n,m;
        int i,q;
        n = haystack.length();
        m = needle.length();
        int[] next = makeNext(arr);
        for (i = 0,q = 0; i < n; ++i)
        {
            while(q > 0 && needle.charAt(q) != haystack.charAt(i))
                q = next[q-1];
            if (needle.charAt(q) == haystack.charAt(i))
            {
                q++;
            }
            if (q == m)
            {
                return i-m+1;
            }
        }
        return -1;
    }

    private static int[] makeNext(char[] arr){
        int len = arr.length;
        int[] next = new int[len];
        int q,k;//q:模版字符串下标；k:最大前后缀长度
        int m = len;//模版字符串长度
        next[0] = 0;//模版字符串的第一个字符的最大前后缀长度为0
        for (q = 1,k = 0; q < m; ++q)//for循环，从第二个字符开始，依次计算每一个字符对应的next值
        {
            while(k > 0 && arr[q] != arr[k])//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
                k = next[k-1];          //不理解没关系看下面的分析，这个while循环是整段代码的精髓所在，确实不好理解
            if (arr[q] == arr[k])//如果相等，那么最大相同前后缀长度加1
            {
                k++;
            }
            next[q] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("BBC ABCDAB ABCDABCDABDE","ABCDABD"));
    }
}

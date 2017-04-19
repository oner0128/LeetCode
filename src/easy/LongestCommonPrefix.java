package easy;


/**
 * Created by rrr on 2017/4/15.
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {


    //水平排除 一个个数组比较
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        String pre = strs[0];
        int i = 1;
        for (String str:strs){
            while (str.indexOf(pre)!=0)pre=pre.substring(0,pre.length()-1);
            if (pre.equals(""))break;
        }
        return pre;
    }
    //12ms 垂直排除 对每个数组的第一个字符进行比较
    //先找出最小字符串长度，再对每个字符从左向右遍历
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c=strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i==strs[j].length()||strs[j].charAt(i)!=c)return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }
    //10ms 分治算法，LCP(S1...Sn)=LCP(LCP(S1...Smid)LCP(Smid+1...Sn))
    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0 || strs == null) return "";
        return longestCommonPrefix3(strs,0,strs.length-1);
    }

    private static String longestCommonPrefix3(String[] strs, int start, int end) {
        if (start>=end)return strs[start];
        int mid=(start+end)/2;
        String left=longestCommonPrefix3(strs,start,mid);
        String right=longestCommonPrefix3(strs,mid+1,end);
//        while (right.indexOf(left)!=0)left=left.substring(0,left.length()-1);
        for (int i = 0; i < left.length(); i++) {
            char c=left.charAt(i);
            if (i==right.length()||right.charAt(i)!=c)return left.substring(0,i);
        }
        return left;
    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"leets", "leetcode", "leetc", "leeds"}));
        System.out.println(longestCommonPrefix3(new String[]{"leets", "leetcode", "leetc", "leeds","le"}));
        System.out.println("cvvc".substring(0, 3));
    }
}

/**
 * Created by rrr on 2017/5/7.
 * 题目描述
 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public static int StrToInt(String str) {
        if (str==null||str.length()==0)return 0;
        int i=0;
        int sum=0;boolean positive=true;
        if (str.charAt(0)=='+'||str.charAt(0)=='-')positive=str.charAt(0)=='-'?false:true;
        while (i<str.length()){
            if (i==0&&(str.charAt(0)=='+'||str.charAt(0)=='-')){i++;continue;}
            int tmp=0;
            if (str.charAt(i)<='9'&&str.charAt(i)>='0'){tmp=str.charAt(i++)-'0';
            sum=sum*10+tmp;}
            else return 0;
        }
        return positive?sum:(~sum+1);
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("+2147483648"));
    }
}

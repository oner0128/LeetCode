package medium;

/**
 * Created by rrr on 2017/4/19.
 * 8. String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        //1. Empty string
        if (str.length()==0||str==null)return 0;

        int i = 0, sign = 1, sum = 0;

        //2. Remove Spaces
        while (i < str.length() && str.charAt(i) == ' ') i++;
        //3. Handle signs
        if (str.charAt(i) == '+' || str.charAt(i) == '-') sign = str.charAt(i++) == '+' ? 1 : -1;
        //4. Convert number and avoid overflow
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //check if total will be overflow after 10 times and add digit
            if (sum>Integer.MAX_VALUE/10||(sum==Integer.MAX_VALUE/10&&str.charAt(i)-'0'>7)){
                if (sign==1)return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            sum=sum*10+str.charAt(i++)-'0';
        }
        return sign * sum;
    }
}

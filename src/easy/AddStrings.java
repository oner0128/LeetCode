package easy;

/**
 * Created by rrr on 2017/4/19.
 */
public class AddStrings {
    //26ms
    public String addStrings(String num1, String num2) {
        char[]digit1=num1.toCharArray();
        char[]digit2=num2.toCharArray();
        int[]sum=new int[Math.max(digit1.length,digit2.length)+1];
        int i=digit1.length-1,j=digit2.length-1;
        int carry=0,index=sum.length-1;
        while (i>=0||j>=0){
            int one=i>=0?digit1[i--]-'0':0;
            int two=j>=0?digit2[j--]-'0':0;
            int tmp=one+two+carry;
            int mod=tmp%10;
            carry=tmp/10;
            sum[index--]=mod;
        }
        if (carry==1)sum[index]=carry;
        StringBuilder sb=new StringBuilder();
        for (int k:sum)if (!(sb.length()==0&&k==0))sb.append(k);
        return sb.length()==0?"0":sb.toString();
    }
    //优化代码 23ms
    public String addStrings2(String num1, String num2) {
        char[]digit1=num1.toCharArray();
        char[]digit2=num2.toCharArray();
        int i=digit1.length-1,j=digit2.length-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while (i>=0||j>=0||carry==1){
            int tmp=(i>=0?digit1[i--]-'0':0)+(j>=0?digit2[j--]-'0':0)+carry;
            carry=tmp/10;
            sb.append(tmp%10);
        }
        return sb.reverse().toString();
    }
}

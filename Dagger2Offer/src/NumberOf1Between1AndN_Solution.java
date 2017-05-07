import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by rrr on 2017/5/6.
 * 题目描述
 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN_Solution {
   /* 假设N，我们要计算百位上出现1的次数，将由三部分决定：百位上的数字，百位以上的数字，百位一下的数字。

    如果百位上的数字为0，则百位上出现1的次数仅由更高位决定，比如12013，
    百位出现1的情况为100~199,1100~1199,2100~2199，…，11100~11199，共1200个。等于更高位数字乘以当前位数，即12 * 100。

    如果百位上的数字大于1，则百位上出现1的次数仅由更高位决定，比如12213，
    百位出现1的情况为100~199,1100~1199,2100~2199，…，11100~11199，12100~12199共1300个。等于更高位数字加1乘以当前位数，即（12 + 1）*100。

    如果百位上的数字为1，则百位上出现1的次数不仅受更高位影响，还受低位影响。例如12113，
    受高位影响出现1的情况：100~199,1100~1199,2100~2199，…，11100~11199，共1200个，但它还受低位影响，出现1的情况是12100~12113，共14个，
    等于低位数字13+1。
    */
   public static int NumberOf1Between1AndN_Solution(int n) {
        int[]dp=new int[10];
        for (int i = 1; i < 10; i++) {//求n中1~9出现的个数
            int base=1;
            int cur=0,head=0,rear=0;
            while ((n/base)!=0){
                cur=(n/base)%10;
                head=n/(base*10);
                rear=n-(n/base)*base;
                if (cur>i)dp[i]+=(head+1)*base;
                else if (cur<i)dp[i]+=head*base;
                else {
                    dp[i]+=head*base+rear+1;
                }
                base*=10;
            }
        }
       int base=1;
       int cur=0,head=0,rear=0;
       while ((n/base)!=0){//求n中0出现的个数
           cur=(n/base)%10;
           head=n/(base*10);
           rear=n-(n/base)*base;
           if (cur==0) dp[0]+=(head-1)*base+rear+1;
           else {
               dp[0]+=head*base;
           }
           base*=10;
       }
        return dp[1];
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(19));
    }
}

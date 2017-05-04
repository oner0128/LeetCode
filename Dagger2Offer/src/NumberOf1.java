/**
 * Created by rrr on 2017/5/3.
 * 题目描述
 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count=0;
        while (n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new NumberOf1().NumberOf1(1331));
    }
}

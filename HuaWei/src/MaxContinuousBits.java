import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 输入: 一个byte型的数字
 输出: 无
 返回: 对应的二进制数字中1的最大连续数
 */
public class MaxContinuousBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(maxContinuousBits(num));
        }
        scanner.close();
    }
    public static int  maxContinuousBits(int num){
        int max=0;
        int tmp=0;
        while (num>0){
            if((num&1)==0)tmp=0;
            else tmp++;
//            System.out.println(num&1);
            max=Math.max(max,tmp);
            num= num>>1;
        }
        return max;
    }
}

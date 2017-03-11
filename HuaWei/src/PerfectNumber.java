import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * 给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 * 返回n以内完全数的个数。异常情况返回-1
 */
public class PerfectNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
//            perfectNumber(scanner.nextInt());
            int n = scanner.nextInt();
            int count = 0;
            //1不是完备数，从2开始遍历
            for(int i=2;i<=n;i++){
                if(isPerfect(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static int perfectNumber(int num){
        return 0;
    }
    private static boolean isPerfect(int src){
        int sum = 1;
        for(int i =2;i*i<=src;i++){
            if(src%i==0){
                sum +=i;
                sum+=src/i;
            }
        }

        if(sum==src){
            return true;
        }
        return false;
    }
}

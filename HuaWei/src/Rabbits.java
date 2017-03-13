import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，
 * 小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，
 * 问每个月的兔子总数为多少？
 *
 * 斐波那契数列问题
 */
public class Rabbits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();
//            System.out.println(rabbits(month));
            System.out.println(rabbits2(month));
        }
    }

//    public static int rabbits(int month) {
//        if (month==2||month==1)return 1;
//        return rabbits(month-1)+rabbits(month-2);
//    }
    //非递归方法
    public static int rabbits2(int month) {
//        if (month==2||month==1)return 1;
        int a=1,b=0,c=0;//a为第一个月，b为第二个月，c为第三个月
        while (--month>=0){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
}

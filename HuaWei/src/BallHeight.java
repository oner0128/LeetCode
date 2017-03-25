import java.util.Scanner;

/**
 * Created by rrr on 2017/3/25.
 * 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 输入描述:
 * 输入起始高度，int型
 * <p>
 * <p>
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 * <p>
 * 输入例子:
 * 1
 * <p>
 * 输出例子:
 * 2.875
 * 0.03125
 */
public class BallHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int high = scanner.nextInt();
            getHeight(high);

            double[] results2 = getHeight2(high);
            System.out.println(results2[0]);
            System.out.println(results2[1]);
            getHeight3(high);
        }
        scanner.close();
    }

    public static void getHeight(int high) {
        double[] results = new double[2];
        double doubleHigh = high;
        double highSum = 0;
        for (int i = 0; i < 4 * 2 + 1; i++) {
            highSum += doubleHigh;
            if (i % 2 == 0) doubleHigh /= 2;
        }
        results[0] = highSum;
        results[1] = doubleHigh;
        System.out.println(results[0]);
        System.out.println(results[1]);
    }

    //将下降和弹起看做一步，因为要求第五次落地时的路程因此需减去最后一次的弹起
    public static double[] getHeight2(int high) {
        double[] results = new double[2];
        double doubleHigh = high;
        double highSum = 0;
        for (int i = 0; i < 5; i++) {
            highSum += doubleHigh + doubleHigh / 2;
            doubleHigh /= 2;
        }
        results[0] = highSum - doubleHigh;
        results[1] = doubleHigh;
        return results;
    }
    //除了第一次，其余次下降和弹起是相等的，后一回合的总路径等于前一回合的高度，除了第一次一共还要4个回合。
    //例如 第二回合开始前 sum=1, 开始后 sum=1+0.5+0.5=1+1。
    public static void getHeight3(int high) {
        double n = high;

        double sum = high;

        for (int i = 1; i <= 4; i++) {
            sum = sum + n;
            n = n / 2;
        }
        System.out.println(sum);
        System.out.println(n / 2);
    }
}

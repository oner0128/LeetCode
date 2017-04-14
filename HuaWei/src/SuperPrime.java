import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class SuperPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        isSuperPrime2(n);
        scanner.close();
    }

    public static boolean isPrime(long nums) {
        if (nums <= 1) return false;
        for (int i = 2; i * i <= nums; i++) {
            if (nums % i == 0) return false;
        }
        return true;
    }

    public static void isSuperPrime(long nums) {
        int m = (int) Math.sqrt(nums) + 1;
        int n=2;
        while (m >= n) {
            double sqrt = Math.pow(nums, 1d / n);
            if ((long) sqrt == sqrt && isPrime((long) sqrt)) {
                System.out.println((long) sqrt + " " + n);
                return;
            }
            n++;
        }
        System.out.println("No");
    }
    public static void isSuperPrime2(long nums) {
        int m = (int) Math.sqrt(nums) + 1;
        for (int i = 2; i <= m; i++) {
            double sqrt = Math.pow(nums, 1d / i);
            if ((long) sqrt == sqrt && isPrime((long) sqrt)) {
                System.out.println((long) sqrt + " " +i);
                return;
            }
        }
        System.out.println("No");
    }
}

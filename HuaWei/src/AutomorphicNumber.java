import java.util.Scanner;

/**
 * Created by rrr on 2017/3/23.
 * 题目描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 */
public class AutomorphicNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(automorphicNumber(scanner.nextInt()));
            System.out.println(automorphicNumber3(scanner.nextInt()));
        }
    }

    public static int automorphicNumber(int num) {
        int result = 0;
        for (int i = 0; i <= num; i++) {
            if (i == 0 || i == 1) result++;
            else if ((i * i % Math.pow(10, (int) Math.log10(i) + 1)) == i)
                result++;
        }
        return result;
    }

    public static int automorphicNumber2(int num) {
        int result = 0;
        for (int i = 0; i <= num; i++) {
            Integer square = i * i;
            if (square.toString().matches("\\d*" + i + "{1}")) result++;
        }
        return result;
    }

    public static int automorphicNumber3(int num) {
        int result = 0;
        for (int i = 0; i <= num; i++) {
            if (isNum(i))
                result++;
        }
        return result;
    }

    public static boolean isNum(int num) {
        int result = num * num;
        while (num > 0) {
            int value1 = num % 10;
            int value2 = result % 10;
            num /= 10;
            result /= 10;

            if (value1 != value2) {
                return false;
            }

        }
        return true;
    }
}

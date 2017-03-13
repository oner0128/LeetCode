import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 */
public class NicoChaseTheorem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(nicoChaseTheorem(num));
        }
    }

    public static String nicoChaseTheorem(int num) {
        if (num==1)return 1+"";
        int cube = (int) Math.pow(num, 3);
        System.out.println(cube);
        StringBuilder stringBuilder = new StringBuilder();
        int tmp = 0;
        if ((num & 1) == 0) {
            for (int i = -num / 2; i < num / 2 - 1; i++) {
                System.out.println(i);
                tmp = cube / num + 2 * i + 1;
                stringBuilder.append(tmp + "+");
            }
            stringBuilder.append(tmp + 2);
        } else { for (int i = -num / 2; i < num / 2 ; i++) {
            System.out.println(i);
            tmp = cube / num + 2 * i ;
            stringBuilder.append(tmp + "+");
        }
            stringBuilder.append(tmp + 2);
        }
        return stringBuilder.toString();
    }
}


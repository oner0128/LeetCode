import java.util.Scanner;

/**
 * Created by hrong on 2017/1/9.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double num = scanner.nextDouble();
            int caryy = (int) (num * 10 % 10);
            if (caryy >= 5) {
                num +=1;
                System.out.println((int) num);
            } else
                System.out.println((int) num);
        }
    }
}

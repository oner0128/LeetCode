
import java.util.Scanner;

/**
 * Created by rrr on 2017/4/20.
 */
public class PrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            StringBuilder sb=new StringBuilder();
            while (n > 1) {
                for (int i = 2; i <= n; i++) {
                    if (n % i == 0) {
                        sb.append(i+" ");
                        n /= i;
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}

import java.util.Scanner;

/**
 * Created by rrr on 2017/4/20.
 */
public class CutString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            System.out.println(cut(input.next(), input.nextInt()));
        }
    }

    private static String cut(String str, int k) {
        int head = 0;
        StringBuilder sb = new StringBuilder();
        while (k > 0 && head < str.length()) {
            if (str.charAt(head) >= 0x0391 && str.charAt(head) <= 0xFFE5) {
                if (k >= 2) sb.append(str.charAt(head));
                k -= 2;head++;
            } else {
                sb.append(str.charAt(head++));
                k -= 1;
            }
        }
        return sb.toString();
    }
}

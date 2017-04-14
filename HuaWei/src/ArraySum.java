import java.util.Scanner;

/**
 * Created by rrr on 2017/4/12.
 */
public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(" ");
            int n = Integer.parseInt(str[0]);int len = Integer.parseInt(str[1]);
            cal(n,len);
        }
    }

    private static void cal(int n, int len) {
        if (len==1){
            System.out.println();
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class ResolveParams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(resolveParams(scanner.nextLine()));
        }
    }
    public static String resolveParams(String command){
        String[]s=command.split(" ");
        for (String c:s){
//            c.split("\\\\");
            c.split("“");
            c.split("\\“");
        }
        System.out.println(Arrays.toString(s));
        return null;
    }
}

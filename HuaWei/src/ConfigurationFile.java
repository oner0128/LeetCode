
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class ConfigurationFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[][] COMMAND = {{"reset", ""}, {"reset", "board"},
                {"board", "add"}, {"board", "delet"},
                {"reboot", "backplane"}, {"backplane", "abort"}};
        final String[] EXECUTE = {"reset what", "board fault",
                "where to add", "no board at all",
                "impossible", "install first", "unkown command"};
        String in = scanner.nextLine();
        scanner.close();
        String[] ins = in.split(" ");
        int count = 0;
        int tmp = 6;
        if (ins.length == 1 && COMMAND[0][0].contains(ins[0])) {
            System.out.println(EXECUTE[0]);
        } else {
            for (int i = 1; i < COMMAND.length; i++) {
                if (COMMAND[i][0].contains(ins[0]) && COMMAND[i][1].contains(ins[1])) {
                    count++;
                    tmp = i;
                }
            }
        }
        if (count != 1) System.out.println(EXECUTE[EXECUTE.length - 1]);
        else System.out.println(EXECUTE[tmp]);
    }
}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/6/30.
 */
public class StringSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            for (String s : getSortStrings(strings)) {
                System.out.println(s);
            }
        }
    }
    //使用现有库排序
    private static String[] getSortStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new String[]{};
//        Collections.sort(Arrays.asList(strings));
        Arrays.sort(strings);
        System.out.println(Arrays.stream(strings).count());
        return strings;
    }
}

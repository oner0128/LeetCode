import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner((System.in));
        String s=scanner.nextLine();
        System.out.println(stringReverse(s));
        stringReverse2(s);
    }

    private static String stringReverse(String s) {
       StringBuilder stringBuilder=new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            stringBuilder.append(s.charAt(i));}
        return stringBuilder.toString();
    }
    private static void stringReverse2(String s) {
        byte[] b = s.getBytes();
        for (int i = b.length-1; i >= 0; i--) {
            System.out.print((char)b[i]);
        }
    }
}

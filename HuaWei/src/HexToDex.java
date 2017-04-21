import java.util.Scanner;

/**
 * Created by rrr on 2017/4/21.
 */
public class HexToDex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s="ABCDEF";
        while (input.hasNext()) {
            String hex = input.next();
            int dex=0;
            int i=hex.length()-1;int base=1;
            while (i>1){
                if (s.indexOf(hex.charAt(i))==-1)dex+=Integer.parseInt(hex.charAt(i)+"")*base;
                else dex+=(s.indexOf(hex.charAt(i))+10)*base;
                i--;base*=16;
            }
            System.out.println(dex);
        }
    }
}

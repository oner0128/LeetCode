import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/25.
 * 合法IP
 * 题目描述
 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
 现在需要你用程序来判断IP是否合法。
 */
public class LegalIP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            System.out.println(legalIP(ip));
        }
        scanner.close();
    }
    public static String legalIP(String ip){
        String noLegal="NO";
        if (ip.matches("[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}")){
            String[]nums=ip.split("\\.");
            System.out.println(Arrays.toString(nums));
            for (String num:nums){
                int ipNum=Integer.parseInt(num);
                if (ipNum>255||ipNum<0){return noLegal;}
            }
            return "YES";
        }
        return noLegal;
    }
}

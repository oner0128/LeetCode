import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 */
public class PasswordStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.next();
            System.out.println(passwordStrength(password));
        }
    }

    public static String passwordStrength(String password) {
        String[] passwordLevel = {"VERY_WEAK", "WEAK", "AVERAGE", "STRONG", "VERY_STRONG", "SECURE", "VERY_SECURE"};
        int score = 0;
        //密码长度
        int length = password.length();
        score = length > 4 ? (length > 7 ? 25 : 10) : 5;
        System.out.println(score);
        //字母
        boolean lowerCase=password.matches(".*[a-z]+.*");
        System.out.println(lowerCase);
        boolean uperCase=password.matches(".*[A-Z]+.*");
        System.out.println(uperCase);
        score+=(lowerCase&&uperCase?20:(lowerCase||uperCase?10:0));
        System.out.println(score);
        //数字
        boolean digsNums1=password.matches(".*\\d+.*");
        System.out.println(digsNums1);
        boolean digsNums2=password.matches(".*\\d+.*\\d+.*");
        System.out.println(digsNums2);
        score+=(digsNums2?20:(digsNums1?10:0));
        System.out.println(score);
        //字符
        boolean charNums1=password.matches(".*[\\x21-\\x2F|\\x3A-\\x40|\\x5B-\\x60|\\x7B-\\x7E]+.*");
        System.out.println(charNums1);
        boolean charNums2=password.matches(".*[\\x21-\\x2F|\\x3A-\\x40|\\x5B-\\x60|\\x7B-\\x7E]+.*[\\x21-\\x2F|\\x3A-\\x40|\\x5B-\\x60|\\x7B-\\x7E]+.*");
        System.out.println(charNums2);
        score+=(charNums2?25:(charNums1?10:0));
        System.out.println(score);
        //奖励
        if (lowerCase&&uperCase&&digsNums1&&charNums1)score+=5;
        else if ((lowerCase||uperCase)&&digsNums1&&charNums1)score+=3;
        else if ((lowerCase||uperCase)&&digsNums1)score+=2;
        if (score>=90)return passwordLevel[6];
        else if (score>=80)return passwordLevel[5];
        else if (score>=70)return passwordLevel[4];
        else if (score>=60)return passwordLevel[3];
        else if (score>=50)return passwordLevel[2];
        else if (score>=25)return passwordLevel[1];
        else  return passwordLevel[0];
    }
}


import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class CalcuDaysNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println(calcuDaysNumbers(year, month, day));
    }

    private static int calcuDaysNumbers(int year, int month, int day) {
        if (month>12||month<1||day>31||day<1)return -1;
        int days = 0;
        while (--month>0){
        if ( month == 4 || month == 6 || month == 9 || month == 11) days += 30;
        else if (month == 2)days+=28;
        else days+=31;}
        if (year%400==0||(year%4==0&&year%100!=0))return days+=day+1;
        return days+=day;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rrr on 2017/3/13.
 */
public class Chickens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
//            System.out.println(chickens(num));
           chickens(num);chickens2(num);
        }
        scanner.close();
    }
    public static void chickens(int num) {
        for (double i = 0; i <= 20; i++) {
            for (double j = 0; j <= 33; j++) {
                for (double k = 0; k <= 100; k++) {
                    if (((i * 5 + j * 3 + k / 3) == 100.0)&&((i + j + k)== 100))//两个条件，百钱和百鸡，之前只满足了百钱
                        System.out.println((int) i+" "+(int) j+" "+(int) k);
                }
            }
        }
    }
    //将百鸡条件加入到For的循环条件中
    public static void chickens2(int num) {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 100-i; j++) {
               int k=100-i-j;
                    if (((i * 5 + j * 3 + k / 3) == 100.0)&&k%3== 0)//两个条件，百钱和百鸡，之前只满足了百钱
                        System.out.println(i+" "+j+" "+k);
                }
            }
        }
    }


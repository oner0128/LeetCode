import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class FindNumbersOf1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(findNumbersOf1(scanner.nextInt()));
        }
    }
    public static int findNumbersOf1(int num){
        int count=0;
        while (num>0){
            if ((num&1)==1)count++;
            num=num>>>1;
        }
        return count;
    }
}

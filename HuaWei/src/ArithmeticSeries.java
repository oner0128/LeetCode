import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 * 等差数列前N项和
 * 等差数列 2，5，8，11，14。。。。
 输入:正整数N >0
 输出:求等差数列前N项和
 返回:转换成功返回 0 ,非法输入与异常返回-1
 */
public class ArithmeticSeries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            System.out.println(arithmeticSeries(n));
        }

    }
    public static int arithmeticSeries(int n){
        int sumN=0;
        int a0=2;
        while (n>0){
            sumN=sumN+a0;
            a0+=3;
            n--;
        }
        return sumN;
    }
}

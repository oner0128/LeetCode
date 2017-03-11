import java.util.Scanner;

/**
 * Created by rrr on 2017/3/9.
 */
public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int m=scanner.nextInt();
            int n=scanner.nextInt();
            System.out.println(m*n/greatestCommondivisor(m,n));
        }
    }
    public static int greatestCommondivisor(int i, int j){
        if (j>i){int tmp=j;
        j=i;
        i=tmp;}
        int k=1;
        while (j!=0){k=i%j;
        i=j;j=k;}
        return i;
    }
}
